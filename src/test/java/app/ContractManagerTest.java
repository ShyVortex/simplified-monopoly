package app;

import it.unimol.monopoly.app.Contract;
import it.unimol.monopoly.app.ContractManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for the Contract Manager")
class ContractManagerTest {
    ContractManager contractsTest;
    Contract contract1, contract2;
    int id1, id2;

    @BeforeEach
    public void init() {
        try {
            contractsTest = loadContracts();
        } catch (FileNotFoundException e) {
            contractsTest = new ContractManager();
        }

        contract1 = new Contract("Test1", 100, 25);
        contract2 = new Contract("Test2", 85, 15);

        id1 = 1;
        id2 = 2;
    }

    @Test
    public void mainTest() {
        assertNotNull(contractsTest);
        assertNotNull(contract1);
        assertNotNull(contract2);
        assertNotEquals(contract1, contract2);

        addContracts();

        System.out.println(contract1);
        System.out.println(contract2);

        saveContracts();

        System.out.println("\nTEST SUCCESSFUL.\n");
    }

    @Test
    public void addContracts() {
        contractsTest.getContracts().put(id1, contract1);
        contractsTest.getContracts().put(id2, contract2);
    }

    @Test
    public void saveContracts() {
        try (
                FileOutputStream fileOutStr = new FileOutputStream("src/test/testsaves/contracts.sr");
                ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr)
        ) {
            objOutStr.writeObject(this.contractsTest);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ContractManager loadContracts() throws FileNotFoundException {
        try (
                FileInputStream fileInStr = new FileInputStream("src/test/testsaves/contracts.sr");
                ObjectInputStream objInStr = new ObjectInputStream(fileInStr)
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