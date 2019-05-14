package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.ipiecoles.java.java240")
public class SpringConfig {

   @Bean(name="bitcoinServiceWithoutCache")
   @Scope("singleton")
   public BitcoinService bitcoinServiceWithoutCache(){
      BitcoinService bitcoinService = new BitcoinService();
      bitcoinService.setForceRefresh(true);
      //bitcoinService.setWebPageManager(webPageManager());
      return bitcoinService;
   }
   @Bean(name="bitcoinServiceWithCache")
   @Scope("singleton")
   public BitcoinService bitcoinServiceWithCache(){
      BitcoinService bitcoinService = new BitcoinService();
      bitcoinService.setForceRefresh(false);
      //bitcoinService.setWebPageManager(webPageManager());
      return bitcoinService;
   }


//   @Bean(name="WebPageManager")
//   public WebPageManager webPageManager(){
//      return new WebPageManager();
//   }
//
//   @Bean
//   public ProduitManager produitManager(){
//      ProduitManager produitManager = new ProduitManager();
//      produitManager.setWebPageManager(webPageManager());
//      produitManager.setBitcoinService(bitcoinServiceWithCache());
//
//      return produitManager;
//   }
}
