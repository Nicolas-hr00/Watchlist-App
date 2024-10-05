# Watchlist-App
LOCAL CLASS A MIDDLE LAYER

we need a separration of layers
PRESENTATION LAYER DOES NOT ACCESS OUR DATA LAYER

MIDDLE LAYER IS DOMAIN LAYER 
    *MODEL
       *CompanyListings
        *It has the relevant DATA (THIS DATA DOES NOT NEED AN ID)
        *This has nothing to do with the data, it only shows the listings.

CompanyEntity 
    *we take a company listing entity and transform it into company listing model

Data layer can access the domain Layer 

*StockDao //Function to interact with the database, insert company listings