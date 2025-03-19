## Crypto Price Checker 
Ever wondering what the price of Bitcoin and Ethereum is on the move? Look no further, a fast Crypto Price Checker built using Spring Boot for the backend and React Native (expo) for the frontend. 
Fetches real time cryptocurrency prices using CoinGecko API and displays them in an intuitive mobile app.

## Features
- Get real time Crypto prices for popular currencies (Bitcoin, Ethereum, etc)
- Fetches price based on currency selected (GBP/USD)
- Backend uses Springboot
- Frontend built with React Native (Expo Client)
- Appearance based on System Settings (Light/Dark mode)

## Tech Stack
Backend:
- Java/SpringBoot (REST API)
- Uses CoinGecko API
- Mockito + Junit for testing

Frontend:
- React Native and Expo Client

## How it works
- User selects a Crypto coin (e.g. Bitcoin) and selects currency (e.g. GBP) in the React Native app (runs on my physical Iphone)
- Frontend sends a request to Springboot backend with the selected coin and currency as query parameters
> const url = `http://ipaddress:8080/api/CryptoPrice?cryptoId=${selectedCrypto}&currency=${selectedCurrency}`;
- Uses ip address of where server is running from and port 8080 as I run it from my physical device
- Springboot dynamically builds API URL with @RequestParam cryptoId/currency
- Springboot makes a request to Coingecko API get crypto price by id and retrieves JSON response
- JSON response is stores as POJO (CryptoData)
- Controller sends back price to React Native frontend as response and frontend displays crypto price
- There are also validation/error messages (e.g. if 500 error occurs, if coin is not selected, etc.).

