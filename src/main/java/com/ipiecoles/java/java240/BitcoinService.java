package com.ipiecoles.java.java240;

import java.io.IOException;

public class BitcoinService {



    private WebPageManager webPageManager;
    private Double rate = null;

    private Boolean forceRefresh = false;

    public void setForceRefresh(Boolean forceRefresh) {
        this.forceRefresh = forceRefresh;
    }


    /**
     * Méthode qui renvoie le cours du Bitcoin
     * @return le cours du bitcoin
     * @throws IOException si impossible d'accéder à la bourse
     */
    public Double getBitcoinRate() throws IOException {
        if(rate != null && !forceRefresh){
            System.out.println("Récupération du cours du bitcoin en cache...");
            return rate;
        }

        System.out.println("Récupération du cours du bitcoin sur site distant");
        WebPageManager webPageManager = new WebPageManager();

        String apiResponse = webPageManager.getPageContents("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=EUR");
        apiResponse = apiResponse.replace("{\"EUR\":","");
        apiResponse = apiResponse.replace("}","");
        rate = Double.parseDouble(apiResponse);
        return rate;
    }

    /**
     * Méthode qui renvoie l'équivalent en bitcoin du prix en euro passé en paramètre
     * @param prixEnEuro le prix à convertir
     * @return le prix en bitcoin au taux actuel
     * @throws IOException si impossible d'accéder à la bourse
     */
    public Double getBitcoinPrice(Double prixEnEuro) throws IOException {
        if(rate == null){
            getBitcoinRate();
        }
        return prixEnEuro / rate;
    }
    public WebPageManager getWebPageManager() {
        return webPageManager;
    }

    public void setWebPageManager(WebPageManager webPageManager) {
        this.webPageManager = webPageManager;
    }

}
