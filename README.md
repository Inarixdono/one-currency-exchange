# Alura ONE Challenge - Currency Converter

This program is an opportunity to apply the skills I gained during my Object-Oriented Java training, which was provided by Alura Latam in partnership with Oracle Next Education.

## Features

-   Convert between different currencies
-   Uses real-time exchange rates from exchangerate-api
-   User-friendly console interface

## How to Run

1. Clone the repository
2. Navigate to the project directory
3. Open the folder in your Visual Studio Code
4. Install the dependencies if it's necessary
5. Go to src.main and select App.java
6. Run!

### ❗ An API key is needed.
To get yours, you can go to [exchagerate-api][exchangerate]. Create a file named `.env` in the root and write `API_KEY = "YOUR_API_KEY"` replacing `"YOUR_API_KEY"` for your API key.

## Usage

1.  When the application starts, you will be greeted with a welcome message.
2.  You will be prompted to select the currency you want to convert from.
3.  Enter the amount of currency you want to convert.
4.  You will be prompted to select the currency you want to convert to.
5.  The application will display the conversion rate and the converted amount.

## Error Handling

The application handles errors gracefully. If an error occurs during the conversion process, an error message will be displayed and the application will continue running.

## Exiting the Application

To exit the application, simply enter a "." when prompted to select a currency.

## Dependencies

- Java 22
- Dotenv
- Gson

[exchangerate]: https://www.exchangerate-api.com/