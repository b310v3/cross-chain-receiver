package org.example;

import java.io.IOException;
import java.io.File;
import java.lang.InterruptedException;
import java.math.BigInteger;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import org.apache.commons.io.FileUtils;

public class RunQuorum {
    private final static String PASSWORD = "6191";
    private static CrossChain contract;

    public void startQuorum() throws Exception {
        closeChain();
        String s;
        Process p;
        BufferedReader br;

        try {
            p = Runtime.getRuntime().exec("/home/belove/quorum/build/bin/geth --datadir /home/belove/quorum/fromscratch/new-node-1 init /home/belove/quorum/fromscratch/genesis.json");
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line : " + s);
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        
            p = Runtime.getRuntime().exec("sh /home/belove/quorum/fromscratch/startnode1.sh");
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line : " + s);
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("Quorum is up and run!");;
    }

    public String Deploy() throws Exception{
        String contractAddress = "";
        
        try {
            Web3j web3 = Web3j.build(new HttpService("http://localhost:22000")); // connect to the quorum node
            Credentials credentials = WalletUtils.loadCredentials(PASSWORD, "/home/belove/quorum/fromscratch/new-node-1/keystore/UTC--2020-07-23T16-45-24.835670945Z--0ea747767e35cd57dce49d756d5a1629995782b5");

            contract = CrossChain.deploy(web3, credentials, BigInteger.valueOf(0x0), DefaultGasProvider.GAS_LIMIT).send();
            contractAddress = contract.getContractAddress();
            System.out.println(contractAddress);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return contractAddress;

    }

    public String[] Deploy(String contractAddress) throws Exception{
        //contractAddress = "0x" + contractAddress;
        String[] ccdata = new String[5];
        
        try {
            Web3j web3 = Web3j.build(new HttpService("http://localhost:22000")); // connect to the quorum node
            Credentials credentials = WalletUtils.loadCredentials(PASSWORD, "/home/belove/quorum/fromscratch/new-node-1/keystore/UTC--2020-07-23T16-45-24.835670945Z--0ea747767e35cd57dce49d756d5a1629995782b5");

            contract = CrossChain.load(contractAddress, web3, credentials, BigInteger.valueOf(0x0), DefaultGasProvider.GAS_LIMIT);
            System.out.println("Get the Contract!");
            while (true) {
                ccdata[0] = contract.getSender().send();
                ccdata[1] = contract.getReceiver().send();
                ccdata[2] = contract.getData().send();
                ccdata[3] = contract.getSenderChain().send();
                ccdata[4] = contract.getReceiverChain().send();
                if (ccdata[0] != null) {
                    break;
                }
            }

            // sending close chain info

        } catch (IOException e) {
            e.printStackTrace();
            contract.CloseChain().send();
        } catch (InterruptedException e) {
            e.printStackTrace();
            contract.CloseChain().send();
        } catch (Exception e) {
            e.printStackTrace();
            contract.CloseChain().send();
        } catch (Throwable t) {
            t.printStackTrace();
            contract.CloseChain().send();
        }
        contract.CloseChain().send();
        // Check if all node ready to shut down, or else some node cant summit CloseChain
        while (true) {
            if(CheckClose()) {
                closeChain();
                break;
            }
        }
        return ccdata;
    }

    public void PushCrossChain(String sender, String receiver, String data, String senderchain, String receiverchain) throws Exception {
        Random rand = new Random();
        contract.sendCrossChain(BigInteger.valueOf(rand.nextInt(99999)), sender, receiver, data, senderchain, receiverchain).send();
        System.out.println("Success pass the data to the crosschain");
    }

    public boolean CheckClose() throws Exception{
        boolean check = contract.getReceived().send();
        if (check == true){
            closeChain();
            return true;
        }
        return false;
    }

    private void closeChain() throws IOException{
        try {
            Process p = Runtime.getRuntime().exec("killall -INT geth && killall constellation-node");
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File f;

        f = new File("/home/belove/quorum/fromscratch/new-node-1/geth");
        if (f.exists()){
            FileUtils.forceDelete(f);
        }
        f = new File("/home/belove/quorum/fromscratch/new-node-1/quorum-raft-state");
        if (f.exists()){
            FileUtils.forceDelete(f);
        }
        f = new File("/home/belove/quorum/fromscratch/new-node-1/raft-snap");
        if (f.exists()){
            FileUtils.forceDelete(f);
        }
        f = new File("/home/belove/quorum/fromscratch/new-node-1/raft-wal");
        if (f.exists()){
            FileUtils.forceDelete(f);
        }
    }
}