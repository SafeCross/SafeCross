import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, TextInput, Alert, Platform } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import { useNavigation, NavigationProp } from '@react-navigation/native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import axios from 'axios';

// Define your stack param list type
type RootStackParamList = {
  Perfil: undefined;
  Editar: undefined;
  Login: undefined;
};

const PerfilScreen: React.FC = () => {
  const navigation = useNavigation<NavigationProp<RootStackParamList>>();
  const [user, setUser] = useState({ name: '', email: '', deviceId: '' });
  const [editMode, setEditMode] = useState(false);
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [device, setDevice] = useState('');

  const BASE_URL =
    Platform.OS === 'android' ? 'http://10.0.2.2:8082' : 'http://localhost:8082';

  useEffect(() => {
    const loadProfile = async () => {
      try {
        const userId = await AsyncStorage.getItem('userId');
        if (!userId) {
          Alert.alert('Erro', 'Usuário não identificado.');

          return;
        }
        const res = await axios.get(`${BASE_URL}/safecross/v1/users/${userId}`);
        setUser(res.data);
        console.log('Perfil carregado:', res.data);
      } catch {
        Alert.alert('Erro', 'Não foi possível carregar os dados do perfil.');
      }

    };
    loadProfile();
  }, []);

  useEffect(() => {
    setNome(user.name);
    setEmail(user.email);
    setDevice(user.deviceId);
  }, [user]);



  const handleLogout = async () => {
    await AsyncStorage.removeItem('userId');
    await AsyncStorage.removeItem('userEmail');
    await AsyncStorage.removeItem('userName');
    await AsyncStorage.removeItem('userDeviceId');
    navigation.reset({
      index: 0,
      routes: [{ name: 'Login' }],
    });
  };

  return (
    <View style={styles.container}>
      {/* Header com botão de voltar */}
      <View style={styles.header}>
        <TouchableOpacity style={styles.backButton} onPress={() => navigation.goBack()}>
          <Ionicons name="arrow-back" size={28} color="#1976d2" />
        </TouchableOpacity>
        <Text style={styles.title}>Perfil</Text>
        <View style={{ width: 28 }} />
      </View>

      <View style={styles.infoBox}>
        <Text style={styles.label}>Nome</Text>
        <Text style={styles.value}>{user.name}</Text>
        <Text style={styles.label}>E-mail</Text>
        <Text style={styles.value}>{user.email}</Text>
        <Text style={styles.label}>Dispositivo</Text>
        <Text style={styles.value}>{user.deviceId}</Text>
      </View>

      <View style={styles.buttonRow}>
        <>
          <TouchableOpacity style={styles.editButton} onPress={() => navigation.navigate('Editar')}>
            <Ionicons name="create-outline" size={20} color="#fff" />
            <Text style={styles.buttonText}>Editar</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.logoutButton} onPress={handleLogout}>
            <Ionicons name="log-out-outline" size={20} color="#fff" />
            <Text style={styles.buttonText}>Sair</Text>
          </TouchableOpacity>
        </>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#eaf6f3', // fundo igual ao app
    padding: 24,
    top: 40
  },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginBottom: 24,
  },
  backButton: {
    backgroundColor: '#fff',
    borderRadius: 16,
    padding: 4,
    elevation: 2,
    shadowColor: '#1976d2',
    shadowOpacity: 0.1,
    shadowRadius: 6,
    shadowOffset: { width: 0, height: 2 },
  },
  title: {
    fontSize: 22,
    fontWeight: 'bold',
    color: '#1976d2',
    flex: 1,
    textAlign: 'center',
  },
  infoBox: {
    backgroundColor: '#fff',
    borderRadius: 24,
    padding: 20,
    marginBottom: 30,
    elevation: 3,
    shadowColor: '#1abc9c',
    shadowOpacity: 0.08,
    shadowRadius: 8,
    shadowOffset: { width: 0, height: 2 },
  },
  label: {
    fontSize: 15,
    color: '#1976d2',
    marginTop: 10,
  },
  value: {
    fontSize: 17,
    color: '#222',
    marginTop: 2,
    marginBottom: 4,
  },
  input: {
    borderWidth: 1,
    borderColor: '#bbb',
    borderRadius: 12,
    padding: 10,
    fontSize: 16,
    marginTop: 2,
    backgroundColor: '#f4fefd',
    color: '#222',
  },
  buttonRow: {
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  editButton: {
    backgroundColor: '#1976d2',
    padding: 14,
    borderRadius: 12,
    flex: 1,
    marginRight: 8,
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  saveButton: {
    backgroundColor: '#388e3c',
    padding: 14,
    borderRadius: 12,
    flex: 1,
    marginRight: 8,
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  cancelButton: {
    backgroundColor: '#bbb',
    padding: 14,
    borderRadius: 12,
    flex: 1,
    marginLeft: 8,
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  logoutButton: {
    backgroundColor: '#f44336',
    padding: 14,
    borderRadius: 12,
    flex: 1,
    marginLeft: 8,
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  buttonText: {
    color: '#fff',
    fontWeight: 'bold',
    marginLeft: 6,
    fontSize: 15,
  },
});

export default PerfilScreen;