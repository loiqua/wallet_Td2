package com.wallet.wallet2.CrudOperations.test;

import com.wallet.wallet2.Models.Account;
import com.wallet.wallet2.CrudOperations.AccountCrudOperations;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertNotNull;


public class AccountCrudOperationsTest {

    private final AccountCrudOperations accountCrudOperations = new AccountCrudOperations();

    @Test
    public void testFindAll() {
        List<Account> accounts = accountCrudOperations.findAll();
        assertNotNull(accounts);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testSave() {
        // Créez un objet Account à enregistrer
        Account accountToSave = new Account();
        accountToSave.setAccountType("Savings");
        accountToSave.setCurrencyId("USD");

        // Enregistrez l'objet Account
        Account savedAccount = accountCrudOperations.save(accountToSave);

        // Vérifiez si l'objet enregistré n'est pas null
        assertNotNull(savedAccount);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testDelete() {
        // Créez un objet Account à supprimer (remplacez l'ID par un ID existant dans votre base de données)
        Account accountToDelete = new Account();
        accountToDelete.setAccountId("your_account_id");

        // Supprimez l'objet Account
        Account deletedAccount = accountCrudOperations.delete(accountToDelete);

        // Vérifiez si l'objet supprimé n'est pas null
        assertNotNull(deletedAccount);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    // Ajoutez d'autres méthodes de test en fonction de vos besoins.

}
