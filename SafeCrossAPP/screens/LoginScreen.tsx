import React, { useState } from 'react';
import { View, Text, TextInput, Button, Alert, StyleSheet, Platform, TouchableOpacity } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { useNavigation } from '@react-navigation/native';
import axios from 'axios';

const LoginScreen = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigation = useNavigation<any>();

    const BASE_URL =
        Platform.OS === 'android' ? 'http://10.0.2.2:8082' : 'http://localhost:8082';


    const handleLogin = async () => {
        if (!email || !password) {
            Alert.alert('Erro', 'Preencha todos os campos.');
            return;
        }

        try {
            const response = await axios.post(`${BASE_URL}/safecross/v1/users/login`, {
                email,
                password,
            });


            if (response.status === 200) {
                Alert.alert('Sucesso', 'Login realizado com sucesso!');
                const userId = response.data.id;
                const userName = response.data.name;
                const userEmail = response.data.email;
                const userDeviceId = response.data.deviceId;

                console.log('Dados do usuário:', response.data.name, response.data.email, response.data.deviceId);

                await AsyncStorage.setItem('userId', userId.toString());
                await AsyncStorage.setItem('userName', userName.toString());
                await AsyncStorage.setItem('userEmail', userEmail.toString());
                await AsyncStorage.setItem('userDeviceId', userDeviceId.toString());
                navigation.navigate('Home');
            } else {
                Alert.alert('Erro', 'Email ou senha inválidos');
            }
        } catch (error) {
            console.error('Erro ao realizar login:', error);
            Alert.alert('Erro', 'Falha ao realizar login. Verifique os dados e tente novamente.');
        }
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Login</Text>

            <TextInput
                placeholder="Email"
                value={email}
                onChangeText={setEmail}
                style={styles.input}
                autoCapitalize="none"
                keyboardType="email-address"
            />

            <TextInput
                placeholder="Senha"
                value={password}
                onChangeText={setPassword}
                style={styles.input}
                secureTextEntry
            />
            <View style={styles.buttonRow}>
                <TouchableOpacity style={[styles.btn, { marginRight: 8 }]} onPress={handleLogin}>
                    <Text style={{ color: '#fff', textAlign: 'center', fontWeight: 'bold' }}>Entrar</Text>
                </TouchableOpacity>
                <TouchableOpacity
                    style={[styles.btn, { backgroundColor: '#1976d2' }]}
                    onPress={() => navigation.navigate('Register')}
                >
                    <Text style={{ color: '#fff', textAlign: 'center', fontWeight: 'bold' }}>Registrar</Text>
                </TouchableOpacity>
            </View>
        </View>
    );
};

export default LoginScreen;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        padding: 24,
        backgroundColor: '#eaf6f3',
    },
    title: {
        fontSize: 32,
        fontWeight: 'bold',
        color: '#1976d2',
        textAlign: 'center',
        marginBottom: 24,
    },
    input: {
        borderBottomWidth: 1,
        borderBottomColor: '#1976d2',
        padding: 10,
        marginBottom: 16,
        height: 40,
    },
    btn: {
        flex: 1,
        padding: 10,
        borderRadius: 8,
        backgroundColor: '#1976d2'
    },
    buttonRow: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        marginTop: 16,
    }
});
