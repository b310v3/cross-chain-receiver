package org.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.6.1.
 */
@SuppressWarnings("rawtypes")
public class CrossChain extends Contract {
    public static final String BINARY = "608060405260006006556007805460ff1916905534801561001f57600080fd5b506107da8061002f6000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c80637765968b116100665780637765968b1461040d5780638991deb51461041557806398aca9221461041d578063ab9dbd0714610425578063abac1db71461043f5761009e565b80633bc5de30146100a35780635596b9721461012057806355d0ad18146103e15780635e01eb5a146103fd5780635ec9488414610405575b600080fd5b6100ab610447565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100e55781810151838201526020016100cd565b50505050905090810190601f1680156101125780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6103df600480360360c081101561013657600080fd5b81359190810190604081016020820135600160201b81111561015757600080fd5b82018360208201111561016957600080fd5b803590602001918460018302840111600160201b8311171561018a57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156101dc57600080fd5b8201836020820111156101ee57600080fd5b803590602001918460018302840111600160201b8311171561020f57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561026157600080fd5b82018360208201111561027357600080fd5b803590602001918460018302840111600160201b8311171561029457600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156102e657600080fd5b8201836020820111156102f857600080fd5b803590602001918460018302840111600160201b8311171561031957600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561036b57600080fd5b82018360208201111561037d57600080fd5b803590602001918460018302840111600160201b8311171561039e57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506104de945050505050565b005b6103e961055c565b604080519115158252519081900360200190f35b6100ab610577565b6100ab6105d7565b6103df610638565b6100ab610643565b6100ab6106a4565b61042d610702565b60408051918252519081900360200190f35b6103e9610708565b60038054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156104d35780601f106104a8576101008083540402835291602001916104d3565b820191906000526020600020905b8154815290600101906020018083116104b657829003601f168201915b505050505090505b90565b600086905584516104f6906001906020880190610711565b50835161050a906002906020870190610711565b50825161051e906003906020860190610711565b508151610532906004906020850190610711565b508051610546906005906020840190610711565b50506007805460ff191660011790555050505050565b600060065460031415610571575060016104db565b50600090565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156104d35780601f106104a8576101008083540402835291602001916104d3565b60048054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156104d35780601f106104a8576101008083540402835291602001916104d3565b600680546001019055565b60058054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156104d35780601f106104a8576101008083540402835291602001916104d3565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156104d35780601f106104a8576101008083540402835291602001916104d3565b60005490565b60075460ff1690565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061075257805160ff191683800117855561077f565b8280016001018555821561077f579182015b8281111561077f578251825591602001919060010190610764565b5061078b92915061078f565b5090565b5b8082111561078b576000815560010161079056fea26469706673582212204a611cea45398124b71dc07571be4fc3b6aa273e26b85a8bcab8a4988a747c5b64736f6c634300060c0033";

    public static final String FUNC_CLOSECHAIN = "CloseChain";

    public static final String FUNC_GETDATA = "getData";

    public static final String FUNC_GETID = "getID";

    public static final String FUNC_GETREADY = "getReady";

    public static final String FUNC_GETRECEIVED = "getReceived";

    public static final String FUNC_GETRECEIVER = "getReceiver";

    public static final String FUNC_GETRECEIVERCHAIN = "getReceiverChain";

    public static final String FUNC_GETSENDER = "getSender";

    public static final String FUNC_GETSENDERCHAIN = "getSenderChain";

    public static final String FUNC_SENDCROSSCHAIN = "sendCrossChain";

    @Deprecated
    protected CrossChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CrossChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CrossChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CrossChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> CloseChain() {
        final Function function = new Function(
                FUNC_CLOSECHAIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getData() {
        final Function function = new Function(FUNC_GETDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getID() {
        final Function function = new Function(FUNC_GETID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> getReady() {
        final Function function = new Function(FUNC_GETREADY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> getReceived() {
        final Function function = new Function(FUNC_GETRECEIVED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> getReceiver() {
        final Function function = new Function(FUNC_GETRECEIVER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getReceiverChain() {
        final Function function = new Function(FUNC_GETRECEIVERCHAIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getSender() {
        final Function function = new Function(FUNC_GETSENDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getSenderChain() {
        final Function function = new Function(FUNC_GETSENDERCHAIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> sendCrossChain(BigInteger _chainid, String _sender, String _receiver, String _data, String _senderchain, String _receiverchain) {
        final Function function = new Function(
                FUNC_SENDCROSSCHAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_chainid), 
                new org.web3j.abi.datatypes.Utf8String(_sender), 
                new org.web3j.abi.datatypes.Utf8String(_receiver), 
                new org.web3j.abi.datatypes.Utf8String(_data), 
                new org.web3j.abi.datatypes.Utf8String(_senderchain), 
                new org.web3j.abi.datatypes.Utf8String(_receiverchain)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static CrossChain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CrossChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CrossChain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CrossChain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CrossChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CrossChain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CrossChain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CrossChain.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CrossChain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CrossChain.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CrossChain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CrossChain.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CrossChain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CrossChain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
