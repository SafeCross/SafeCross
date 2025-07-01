import React, { useState } from 'react';
import { View, Text, TextInput, Button, Alert, StyleSheet, Platform, TouchableOpacity } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import axios from 'axios';

const RegisterScreen = () => {
    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [deviceId, setDeviceId] = useState('');
    const navigation = useNavigation<any>();

    const BASE_URL =
        Platform.OS === 'android' ? 'http://10.0.2.2:8082' : 'http://localhost:8082';

    const handleRegister = async () => {
        if (!name || !email || !password) {
            Alert.alert('Erro', 'Preencha todos os campos obrigatórios.');
            return;
        }

        console.log('Registrando usuário:', {
            name,
            email,
            password,
            deviceId,
        });

        try {
            const response = await axios.post(`${BASE_URL}/safecross/v1/users`, {
                name,
                email,
                password,
                deviceId,
            });

            if (response.status !== 200) {
                throw new Error('Falha ao registrar usuário');
            }

            Alert.alert('Sucesso', 'Usuário registrado com sucesso!');
            navigation.navigate('Login');
        } catch (error: any) {
            console.error(error);
            Alert.alert('Erro', 'Falha ao registrar. Verifique os dados e tente novamente.');
        }
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Registrar</Text>

            <TextInput
                placeholder="Nome *"
                value={name}
                onChangeText={setName}
                style={styles.input}
            />


            <TextInput
                placeholder="Email *"
                value={email}
                onChangeText={setEmail}
                style={styles.input}
                autoCapitalize="none"
                keyboardType="email-address"
            />

            <TextInput
                placeholder="Senha *"
                value={password}
                onChangeText={setPassword}
                style={styles.input}
                secureTextEntry
            />

            <TextInput
                placeholder="ID do Dispositivo"
                value={deviceId}
                style={styles.input}
                onChangeText={setDeviceId}
            />

            <TouchableOpacity style={[styles.btn, { marginRight: 8 }]} onPress={handleRegister}>
                <Text style={{ color: '#fff', textAlign: 'center', fontWeight: 'bold' }}>Registrar</Text>
            </TouchableOpacity>
            <TouchableOpacity
                style={{ backgroundColor: '#fff', padding: 12, borderRadius: 8 }}
                onPress={() => navigation.navigate('Login')}
            >
                <Text style={{ color: '#1976d2', textAlign: 'center', fontWeight: 'bold' }}>Já possui uma conta? Faça login</Text>
            </TouchableOpacity>
        </View>
    );
};

export default RegisterScreen;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        padding: 24,
        backgroundColor: '#fff',
    },
    title: {
        fontSize: 24,
        color: '#333',
        textAlign: 'center',
        marginBottom: 16,
    },
    input: {
        borderBottomWidth: 1,
        borderBottomColor: '#1976d2',
        padding: 10,
        marginBottom: 16,
        height: 40,
    },
    btn: {
        marginTop: 16,
        padding: 10,
        borderRadius: 8,
        backgroundColor: '#1976d2'
    }
});
