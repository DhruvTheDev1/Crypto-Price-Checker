import { Text, View, StyleSheet} from "react-native";
import { useThemeColor } from "@/hooks/useThemeColor"; 

export default function Index() {
  const backgroundColor = useThemeColor({}, "background");
  const textColor = useThemeColor({}, "text"); 
  
  return (
    <View style={[styles.container, { backgroundColor }]}>
      <Text style={{ color: textColor }}>Hello World</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
        justifyContent: "center",
        alignItems: "center",
  }
})