import { Stack } from "expo-router";
import { useThemeColor } from "@/hooks/useThemeColor";


export default function RootLayout() {
    const backgroundColor = useThemeColor({}, "background");
    const textColor = useThemeColor({}, "text");

    return (
      <Stack
        screenOptions={{
          //headerShown: false,
          headerStyle: { backgroundColor },
          headerTintColor: textColor,
          contentStyle: { backgroundColor },
        }}
      >
        <Stack.Screen name="index" options={{ title: "Crypto Price Checker" }} />
      </Stack>
    );
}
