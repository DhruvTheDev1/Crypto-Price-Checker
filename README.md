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
> local host 8080 - network address that points to my own computer
> Uses my computers IP address to connect to the local server
- Springboot dynamically builds API URL with @RequestParam cryptoId/currency
- Springboot makes a request to Coingecko API get crypto price by id and retrieves JSON response
- JSON response is stores as POJO (CryptoData)
- Controller sends back price to React Native frontend as response and frontend displays crypto price
- There are also validation/error messages (e.g. if 500 error occurs, if coin is not selected, etc.).

## Testing
The frontend was tested manually using Expo on my Iphone

Backend:
- TestingCryptoController:
  - Tests that mock API response to ensure price is being retrieved and request handling.
  - Test for error when fetching data - when api fails (500 code)
- TestingCryptoService:
  - Mocks API response and JSON values are extracted correctly
> Used Mockito to mock dependencies than mock the class under test

## Getting Started
Prequisites:
- Java 17+
- NodeJS 18+
- Clone the repository

Backend:
- Set up application.properties with API URL - You can use CoinGecko's free API
> Ensure - ids={cryptoId}&vs_currencies={currency}
- Run the backend and test on port 8080
> http://localhost:8080/api/CryptoPrice?cryptoId=ethereum&currency=usd

Frontend:
- Install npm and nodeJS
- Ensure you have the dependencies installed (node modules)
- run "npx expo start" and scan QR code
> const url = `http://ipaddress:8080/api/CryptoPrice?cryptoId=${selectedCrypto}&currency=${selectedCurrency}`;
> Replace "ipaddress" with your own

> https://reactnative.dev/docs/environment-setup to get started with React Native

## App Examples
![image](https://github.com/user-attachments/assets/48df8fec-070f-4607-aebd-a5540e500cf3)  ![image](https://github.com/user-attachments/assets/9503251b-1c95-4df1-94cd-49b6055185f6) ![image](https://github.com/user-attachments/assets/81f02c9b-4455-4c25-9cdc-0f347ad03753)  ![image](https://github.com/user-attachments/assets/1d5cbfb2-4b13-4fce-b27e-36d56ecc2925) ![image](https://github.com/user-attachments/assets/0d1e332d-667b-4de1-8825-8d4d8e34e04c)
 ![image](https://github.com/user-attachments/assets/996a7cc1-51c1-43dd-be19-3be318f4ac47)


 
