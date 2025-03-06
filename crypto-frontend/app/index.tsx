import { Text, View, StyleSheet, TouchableOpacity } from "react-native";
import { useThemeColor } from "@/hooks/useThemeColor";
import { Dropdown } from 'react-native-element-dropdown';
import { useState } from "react";

export default function Index() {
  const backgroundColor = useThemeColor({}, "background");
  const textColor = useThemeColor({}, "text");

  // dropdown - crypto
  // label - crypto name in menu
  // value - cryptoId - coingecko api
  const crypto = [
    { label: 'Bitcoin', value: 'bitcoin' },
    { label: 'Ethereum', value: 'ethereum' },
    { label: 'XRP', value: 'ripple' },
    { label: 'Tether', value: 'tether' },
    { label: 'BNB', value: 'binancecoin' },
    { label: 'Solana', value: 'solana' },
  ]

  const currency = [
    { label: 'GBP', value: 'gbp' },
    { label: 'USD', value: 'usd' },
  ]

  const [selectedCrypto, setSelectedCrypto] = useState(null);
  const [selectedCurrency, setSelectedCurrency] = useState(null);

  const handleSubmit = async () => {
    if (!selectedCrypto || !selectedCurrency) {
      console.warn("Cannot be empty");
      return;
    }
    const url = `ipaddress8080/api/CryptoPrice?cryptoId=${selectedCrypto}&currency=${selectedCurrency}`;
    try {
      const response = await fetch(url);
      const cryptoData = await response.json();
      console.log(selectedCrypto + ":", cryptoData + " " + selectedCurrency);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    <View style={[styles.container, { backgroundColor }]}>
      {/* <Text style={{ color: textColor }}>Select A Crypto Coin!</Text> */}
      <Dropdown
        style={[styles.dropdown, { backgroundColor }]} 
        placeholderStyle={[styles.placeholderStyle, { color: textColor }]} 
        selectedTextStyle={[styles.selectedTextStyle, { color: textColor }]} //
        data={crypto}
        labelField="label" 
        valueField="value" 
        placeholder="Select Crypto"
        value={selectedCrypto}
        onChange={item => setSelectedCrypto(item.value)}
      />

<Dropdown
        style={[styles.dropdown, { backgroundColor }]} 
        placeholderStyle={[styles.placeholderStyle, { color: textColor }]} 
        selectedTextStyle={[styles.selectedTextStyle, { color: textColor }]} 
        data={currency}
        labelField="label" 
        valueField="value" 
        placeholder="Select Currency"
        value={selectedCurrency}
        onChange={item => setSelectedCurrency(item.value)} 
      />
   
   <TouchableOpacity onPress={handleSubmit} style={[styles.submitButton]}>
  <Text style={[styles.submitText, { color: textColor }]}>Check Price</Text>
</TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
   // justifyContent: "center",
    alignItems: "center",
  },
  dropdown: {
    marginTop: 20,
    width: '70%',
    height: 50,
    borderColor: 'gray',
    borderWidth: 1,
    borderRadius: 8,
    paddingHorizontal: 10,
  },
  placeholderStyle: {
    fontSize: 16,
  },
  selectedTextStyle: {
    fontSize: 16,
  },
  submitButton: {
    fontSize: 18,
    marginTop: 20,
    paddingVertical: 10,
    paddingHorizontal: 30,
    borderRadius: 8,
    borderWidth: 1,  
    borderColor: 'gray', 

  },
  
  submitText: {
    fontSize: 18,
    textAlign: "center", 
  }

});