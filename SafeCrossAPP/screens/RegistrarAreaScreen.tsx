import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, TextInput, TouchableOpacity, Alert, ActivityIndicator, Platform } from 'react-native';
import * as Location from 'expo-location';
import { useNavigation } from '@react-navigation/native';
import axios from 'axios';
import AsyncStorage from '@react-native-async-storage/async-storage';

type RootStackParamList = {
    Home: undefined;
    Camera: undefined;
    RegistrarArea: undefined;
    Notificacoes: undefined;
    Perfil: undefined;
    Historico: undefined;
};
import type { StackNavigationProp } from '@react-navigation/stack';

const RegistrarAreaScreen: React.FC = () => {
  const navigation = useNavigation<StackNavigationProp<RootStackParamList>>();
  const [location, setLocation] = useState<{ latitude: number; longitude: number } | null>(null);
  const [desc, setDesc] = useState('');
  const [loading, setLoading] = useState(true);
  const [areas, setAreas] = useState<{ id: number; latitude: number; longitude: number; description: string }[]>([]);

  const BASE_URL =
    Platform.OS === 'android' ? 'http://10.0.2.2:8082' : 'http://localhost:8082';

  useEffect(() => {
    (async () => {
      let { status } = await Location.requestForegroundPermissionsAsync();
      if (status !== 'granted') {
        Alert.alert('Permissão negada', 'Não foi possível obter a localização.');
        setLoading(false);
        return;
      }
      let loc = await Location.getCurrentPositionAsync({});
      setLocation({
        latitude: loc.coords.latitude,
        longitude: loc.coords.longitude,
      });
      setLoading(false);
    })();
  }, []);

  useEffect(() => {
    if (location) {
      fetchAreasByLocation(location.latitude, location.longitude);
    }
  }, [location]);

  const fetchAreasByLocation = async (latitude: number, longitude: number) => {
    try {
      const res = await axios.post(`${BASE_URL}/safecross/v1/affected-areas/find-by-coordinates`, {
        latitude: latitude.toString(),
        longitude: longitude.toString(),
      });

      if (res.status === 200) {
        // Se vier um array, use direto. Se vier um objeto, coloque em array. Se vier null/undefined, array vazio.
        if (Array.isArray(res.data)) {
          setAreas(res.data);
        } else if (res.data && typeof res.data === 'object') {
          setAreas([res.data]);
        } else {
          setAreas([]);
        }
      } else if (res.status === 404) {
        setAreas([]);
      } else {
        setAreas([]);
        Alert.alert('Erro', 'Erro ao buscar registros nesta localização.');
      }
    } catch (error: any) {
      if (error.response && error.response.status === 404) {
        setAreas([]);
      } else {
        setAreas([]);
        Alert.alert('Erro', 'Erro ao buscar registros nesta localização.');
      }
    }
  };

  const handleEnviar = async () => {
    if (!location) return;
    setLoading(true);

    try {
      const userId = await AsyncStorage.getItem('userId');
      if (!userId) {
        Alert.alert('Erro', 'Usuário não identificado.');
        setLoading(false);
        return;
      }

      const payload = {
        userId: Number(userId),
        latitude: location.latitude,
        longitude: location.longitude,
        description: desc,
        validationStatusId: 2
      };

      const response = await axios.post(`${BASE_URL}/safecross/v1/affected-areas`, payload);
      if (response.status === 200) {
        Alert.alert('Registro enviado', 'Sua área foi registrada como pendente.');
      }

      setLoading(false);
    } catch (error) {
      setLoading(false);
      Alert.alert('Erro', 'Não foi possível registrar a área.');
    }
  };

  if (loading) {
    return (
      <View style={styles.center}>
        <ActivityIndicator size="large" color="#1976d2" />
        <Text style={{ marginTop: 10 }}>Obtendo localização...</Text>
      </View>
    );
  }

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Registrar Área Afetada</Text>
      <Text style={styles.label}>Localização atual:</Text>
      <Text style={styles.location}>
        {location
          ? `Lat: ${location.latitude.toFixed(5)}, Lon: ${location.longitude.toFixed(5)}`
          : 'Não disponível'}
      </Text>
      <Text style={styles.label}>Descrição (opcional):</Text>
      <TextInput
        style={styles.input}
        placeholder="Descreva o problema..."
        value={desc}
        onChangeText={setDesc}
        multiline
      />
      
      <View style={styles.buttonRow}>
        <TouchableOpacity style={styles.cancelButton} onPress={() => navigation.navigate('Home')}>
          <Text style={styles.buttonText}>Cancelar</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.sendButton} onPress={handleEnviar}>
          <Text style={styles.buttonText}>Enviar registro</Text>
        </TouchableOpacity>
      </View>
      
      <Text style={[styles.label, { marginTop: 30 }]}>Todos os registros nesta localização:</Text>
      {areas.length === 0 ? (
        <Text style={{ color: '#bbb', marginBottom: 10 }}>Nenhum registro encontrado.</Text>
      ) : (
        areas
          .filter(
            area =>
              area.latitude !== undefined &&
              area.longitude !== undefined &&
              !isNaN(Number(area.latitude)) &&
              !isNaN(Number(area.longitude))
          )
          .map(area => (
            <View key={`all-${area.id}`} style={{ backgroundColor: '#f5f5f5', borderRadius: 12, padding: 12, marginBottom: 10 }}>
              <Text style={{ color: '#1976d2', fontWeight: 'bold' }}>
                Lat: {Number(area.latitude).toFixed(5)}, Lon: {Number(area.longitude).toFixed(5)}
              </Text>
              <Text style={{ color: '#555' }}>{area.description}</Text>
              <Text style={{ color: '#888', fontSize: 12, marginTop: 4 }}>
                ID: {area.id}
              </Text>
            </View>
          ))
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: { 
    top: 40,
    flex: 1, 
    padding: 24, 
    backgroundColor: '#eaf6f3'
  },
  title: { 
    fontSize: 22, 
    fontWeight: 'bold', 
    marginBottom: 20, 
    color: '#1abc9c'
  },
  label: { 
    fontSize: 16, 
    marginTop: 10, 
    color: '#1976d2' 
  },
  location: { 
    fontSize: 15, 
    color: '#555', 
    marginBottom: 10
  },
  input: {
    borderWidth: 1,
    borderColor: '#bbb',
    borderRadius: 16,
    padding: 14,
    minHeight: 60,
    marginTop: 8,
    marginBottom: 16,
    textAlignVertical: 'top',
    backgroundColor: '#fff',
    fontSize: 16,
    color: '#222'
  },
  buttonRow: { 
    flexDirection: 'row', 
    justifyContent: 'space-between', 
    marginTop: 20 
  },
  cancelButton: {
    backgroundColor: '#bbb',
    padding: 14,
    borderRadius: 16,
    flex: 1,
    marginRight: 8,
    alignItems: 'center',
  },
  sendButton: {
    backgroundColor: '#1abc9c',
    padding: 14,
    borderRadius: 16,
    flex: 1,
    marginLeft: 8,
    alignItems: 'center',
    elevation: 2,
    shadowColor: '#1abc9c',
    shadowOpacity: 0.10,
    shadowRadius: 6,
    shadowOffset: { width: 0, height: 2 },
  },
  buttonText: { 
    color: '#fff', 
    fontWeight: 'bold' 
  },
  center: { 
    flex: 1, 
    justifyContent: 'center', 
    alignItems: 'center' 
  }
});

export default RegistrarAreaScreen;