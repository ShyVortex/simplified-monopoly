package it.unimol.monopoly.app;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ContractManagerTest {
    public static void main(String[] args) throws IOException {
        ContractManager contractsTest;
        try {
            contractsTest = loadContracts();
        } catch (FileNotFoundException e) {
            contractsTest = new ContractManager();
        }

        Contract contract1 = new Contract("Test1", 100, 25);
        Contract contract2 = new Contract("Test2", 85, 15);

        assertNotNull(contractsTest);
        assertNotNull(contract1);
        assertNotNull(contract2);
        assertNotEquals(contract1, contract2);

        addContract(contractsTest, 1, contract1);
        addContract(contractsTest, 2, contract2);

        System.out.println(contract1);
        System.out.println(contract2);

        saveContracts(contractsTest);
    }

    @Test
    public static void addContract(ContractManager contracts, int id, Contract contract) {
        contracts.getContracts().put(id, contract);
    }

    @Test
    public static void saveContracts(ContractManager contractsTest) {
        try (
                FileOutputStream fileOutStr = new FileOutputStream("test/it/unimol/monopoly/app/testsaves/contracts.sr");
                ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        ) {
            objOutStr.writeObject(contractsTest);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public static ContractManager loadContracts() throws FileNotFoundException {
        try (
                FileInputStream fileInStr = new FileInputStream("test/it/unimol/monopoly/app/testsaves/contracts.sr");
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