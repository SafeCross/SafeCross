import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import type { StackNavigationProp } from '@react-navigation/stack';
import { Ionicons } from '@expo/vector-icons';

const lights = ['red', 'green', 'yellow'];

export default function SemaforoScreen() {
  const [current, setCurrent] = useState(0);
  const navigation = useNavigation<StackNavigationProp<any>>();

  useEffect(() => {
    let timeout: NodeJS.Timeout;
    if (current === 0) {
      // Vermelho
      timeout = setTimeout(() => setCurrent(1), 4000);
    } else if (current === 1) {
      // Verde
      timeout = setTimeout(() => setCurrent(2), 4000);
    } else if (current === 2) {
      // Amarelo (só acende após o verde)
      timeout = setTimeout(() => setCurrent(0), 1500);
    }
    return () => clearTimeout(timeout);
  }, [current]);

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <TouchableOpacity style={styles.backButton} onPress={() => navigation.navigate('Home')}>
          <Ionicons name="arrow-back" size={28} color="#1976d2" />
        </TouchableOpacity>
        <Text style={styles.title}>Semáforo em tempo real</Text>
      </View>
      <View style={styles.centerContent}>
        <View style={styles.trafficLight}>
          <View style={[styles.light, { backgroundColor: current === 0 ? 'red' : '#330000' }]} />
          <View style={[styles.light, { backgroundColor: current === 1 ? 'green' : '#003300' }]} />
          <View style={[styles.light, { backgroundColor: current === 2 ? 'yellow' : '#333300' }]} />
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#eee' },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingTop: 50,
    paddingBottom: 10,
    paddingHorizontal: 16,
    backgroundColor: '#eee',
  },
  backButton: { marginRight: 10 },
  title: { fontSize: 22, fontWeight: 'bold', color: '#1976d2' },
  centerContent: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  trafficLight: { width: 80, height: 220, backgroundColor: '#222', borderRadius: 20, padding: 15, justifyContent: 'space-between' },
  light: { width: 50, height: 50, borderRadius: 25, marginVertical: 5 },
});