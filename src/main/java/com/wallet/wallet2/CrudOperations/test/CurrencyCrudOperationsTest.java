package com.wallet.wallet2.CrudOperations.test;

import com.wallet.wallet2.Models.Currency;
import com.wallet.wallet2.CrudOperations.CurrencyCrudOperations;
import com.wallet.wallet2.Components.CurrencyComponent;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertNotNull;


public class CurrencyCrudOperationsTest {

    private final CurrencyCrudOperations currencyCrudOperations = new CurrencyCrudOperations();

    @Test
    public void testFindAll() {
        List<Currency> currencies = currencyCrudOperations.findAll();
        assertNotNull(currencies);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testSave() {
        // Créez un objet Currency à enregistrer
        Currency currencyToSave = new Currency();
        currencyToSave.setName("Euro");
        currencyToSave.setCode("EUR");

        // Enregistrez l'objet Currency
        Currency savedCurrency = currencyCrudOperations.save(currencyToSave);

        // Vérifiez si l'objet enregistré n'est pas null
        assertNotNull(savedCurrency);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testDelete() {
        // Créez un objet Currency à supprimer (remplacez l'ID par un ID existant dans votre base de données)
        Currency currencyToDelete = new Currency();
        currencyToDelete.setCurrencyId("your_currency_id");

        // Supprimez l'objet Currency
        Currency deletedCurrency = currencyCrudOperations.delete(currencyToDelete);

        // Vérifiez si l'objet supprimé n'est pas null
        assertNotNull(deletedCurrency);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }

    @Test
    public void testGetCurrencyById() {
        // Créez un ID de devise existant dans votre base de données
        String currencyId = "existing_currency_id";

        // Obtenez l'objet Currency par ID
        CurrencyComponent currencyComponent = currencyCrudOperations.getCurrencyById(currencyId);

        // Vérifiez si l'objet CurrencyComponent n'est pas null
        assertNotNull(currencyComponent);
        // Ajoutez des assertions supplémentaires en fonction de vos besoins.
    }


}
