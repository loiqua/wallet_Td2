package com.wallet.wallet2.CrudOperations.test;

import com.wallet.wallet2.Models.Transaction;
import com.wallet.wallet2.CrudOperations.TransactionCrudOperations;
import com.wallet.wallet2.Components.TransactionComponent;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertNotNull;


public class TransactionCrudOperationsTest {

    private final TransactionCrudOperations transactionCrudOperations = new TransactionCrudOperations();

    @Test
    public void testFindAll() {
        List<Transaction> transactions = transactionCrudOperations.findAll();
        assertNotNull(transactions);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testSave() {
        // Créez un objet Transaction à enregistrer
        Transaction transactionToSave = new Transaction();
        transactionToSave.setDescription("Test Transaction");
        transactionToSave.setAmount(100.0);
        transactionToSave.setAccountId("your_account_id");
        transactionToSave.setTransactionType("expense");
        transactionToSave.setCategoryId("your_category_id");

        // Enregistrez l'objet Transaction
        Transaction savedTransaction = transactionCrudOperations.save(transactionToSave);

        // Vérifiez si l'objet enregistré n'est pas null
        assertNotNull(savedTransaction);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testDelete() {
        // Créez un objet Transaction à supprimer (remplacez l'ID par un ID existant dans votre base de données)
        Transaction transactionToDelete = new Transaction();
        transactionToDelete.setTransactionId("your_transaction_id");

        // Supprimez l'objet Transaction
        Transaction deletedTransaction = transactionCrudOperations.delete(transactionToDelete);

        // Vérifiez si l'objet supprimé n'est pas null
        assertNotNull(deletedTransaction);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testGetTransactionByAccountId() {
        // Créez un ID de compte existant dans votre base de données
        String accountId = "your_account_id";

        // Obtenez la liste des transactions par ID de compte
        List<TransactionComponent> transactions = transactionCrudOperations.getTransactionByAccountId(accountId);

        // Vérifiez si la liste n'est pas null
        assertNotNull(transactions);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testGetById() {
        // Créez un ID de transaction existant dans votre base de données
        String transactionId = "your_transaction_id";

        // Obtenez l'objet Transaction par ID
        Transaction retrievedTransaction = transactionCrudOperations.getById(transactionId);

        // Vérifiez si l'objet n'est pas null
        assertNotNull(retrievedTransaction);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    // Ajoutez d'autres méthodes de test en fonction de vos besoins.
}
