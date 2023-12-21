package com.wallet.wallet2.CrudOperations.test;

import com.wallet.wallet2.Models.Balance;
import com.wallet.wallet2.CrudOperations.BalanceCrudOperations;
import org.junit.Test;


import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class BalanceCrudOperationsTest {

    private final BalanceCrudOperations balanceCrudOperations = new BalanceCrudOperations();

    @Test
    public void testFindAll() {
        List<Balance> balances = balanceCrudOperations.findAll();
        assertNotNull(balances);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testSave() {
        // Créez un objet Balance à enregistrer
        Balance balanceToSave = new Balance();
        balanceToSave.setBalanceTimestamp(LocalDateTime.now());
        balanceToSave.setAccountId("your_account_id");
        balanceToSave.setAmount(100.0);

        // Enregistrez l'objet Balance
        Balance savedBalance = balanceCrudOperations.save(balanceToSave);

        // Vérifiez si l'objet enregistré n'est pas null
        assertNotNull(savedBalance);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testDelete() {
        // Créez un objet Balance à supprimer (remplacez l'ID par un ID existant dans votre base de données)
        Balance balanceToDelete = new Balance();
        balanceToDelete.setBalanceId("your_balance_id");

        // Supprimez l'objet Balance
        Balance deletedBalance = balanceCrudOperations.delete(balanceToDelete);

        // Vérifiez si l'objet supprimé n'est pas null
        assertNotNull(deletedBalance);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testGetLastBalanceOfAccount() {
        // Créez un ID de compte existant dans votre base de données
        String accountId = "your_account_id";

        // Obtenez le solde actuel du compte
        Balance lastBalance = balanceCrudOperations.getLastBalanceOfAccount(accountId);

        // Vérifiez si l'objet Balance n'est pas null
        assertNotNull(lastBalance);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testGetAmountByDate() {
        // Créez un ID de compte existant dans votre base de données
        String accountId = "your_account_id";
        LocalDateTime amountUpdated = LocalDateTime.now();

        // Obtenez le montant total jusqu'à la date spécifiée
        Double totalAmount = balanceCrudOperations.getAmountByDate(accountId, amountUpdated);

        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testGetBalanceHistory() {
        // Créez un ID de compte existant dans votre base de données
        String accountId = "your_account_id";
        LocalDateTime startDate = LocalDateTime.now().minusDays(30);
        LocalDateTime endDate = LocalDateTime.now();

        // Obtenez l'historique des soldes pour la période spécifiée
        List<Balance> balanceHistory = balanceCrudOperations.getBalanceHistory(accountId, startDate, endDate);

        // Vérifiez si la liste n'est pas null
        assertNotNull(balanceHistory);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    // Ajoutez d'autres méthodes de test en fonction de vos besoins.
}
