package it.unimol.monopoly.app;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

/**
 * Class whose aim is to manage contracts. Once they are generated by the method ({@link Game#setMatchContracts(ContractManager)}),
 * they are saved in a key-value map where the key is an integer, representing the ID of each contract, and
 * the value is the contract itself. It implements the {@link Serializable} interface the object's state is saved
 * on a file.
 *
 * @author Angelo
 * @version 2.0
 */

public class ContractManager implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private Map<Integer, Contract> contracts;

    /**
     * It creates the contract manager, by instantiating an empty map.
     */
    public ContractManager() {
        this.contracts = new HashMap<>();
    }

    /**
     * It defines the addition of a contract to the map.
     *
     * @param id Contract ID, which is the map's key.
     * @param contract The contract itself, which is the map's value.
     */
    public void addContract(int id, Contract contract) {
        this.contracts.put(id, contract);
    }

    public Map<Integer, Contract> getContracts() {
        return this.contracts;
    }

    public void setContracts(Map<Integer, Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * Representation of the contract manager as string.
     *
     * @return A string visualization of the manager.
     */
    public String toString() {
        assert this.contracts != null;
        String result = "";
        for (Contract element : contracts.values()) {
            assert element != null;
            result += element + "\n";
        }
        return result;
    }

    /**
     * It handles the save of the contract manager on a file.
     *
     * @throws IOException in case of failure.
     */
    public void saveContracts() throws IOException {
        try (
            FileOutputStream fileOutStr = new FileOutputStream("contracts.sr");
            ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        ) {
            objOutStr.writeObject(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * It handles the load of the contract manager from file.
     *
     * @return An instance of {@code ContractManager} preloaded in case of success.
     * @throws FileNotFoundException returns {@code null} if no save file is found.
     */
    public static ContractManager loadContracts() throws FileNotFoundException {
        try (
            FileInputStream fileInStr = new FileInputStream("contracts.sr");
            ObjectInputStream objInStr = new ObjectInputStream(fileInStr);
        ) {
           Object o = objInStr.readObject();
           return (ContractManager) o;
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}