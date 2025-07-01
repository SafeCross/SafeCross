import React, { useState, useEffect } from 'react';
import { View, Text, TextInput, StyleSheet, TouchableOpacity, Alert, ActivityIndicator, Platform } from 'react-native';
import { useNavigation, useRoute } from '@react-navigation/native';
import axios from 'axios';
import AsyncStorage from '@react-native-async-storage/async-storage';

interface UserProfile {
    id: string;
    name: string;
    email: string;
    phone: string;
    deviceId: string;
}

const BASE_URL =
    Platform.OS === 'android' ? 'http://10.0.2.2:8082' : 'http://localhost:8082';

const EditarScreen: React.FC = () => {
    const navigation = useNavigation();
    const route = useRoute();
    const [profile, setProfile] = useState<UserProfile | null>(null);
    const [loading, setLoading] = useState(true);
    const [saving, setSaving] = useState(false);

    useEffect(() => {
        const loadProfile = async () => {
            try {
                const userId = await AsyncStorage.getItem('userId');
                if (!userId) {
                    Alert.alert('Erro', 'Usuário não identificado.');
                    setLoading(false);
                    return;
                }
                const res = await axios.get(`${BASE_URL}/safecross/v1/users/${userId}`);
                setProfile(res.data);
            } catch {
                Alert.alert('Erro', 'Não foi possível carregar os dados do perfil.');
            }
            setLoading(false);
        };
        loadProfile();
    }, []);

    const handleSave = async () => {
        if (!profile) return;
        setSaving(true);
        try {
            const response = await axios.put(`${BASE_URL}/safecross/v1/users/${profile.id}`, profile);
            if (response.status === 200) {
                Alert.alert('Sucesso', 'Perfil atualizado com sucesso!');
                navigation.goBack();
            } else {
                Alert.alert('Erro', 'Não foi possível atualizar o perfil.');
            }
        } catch {
            Alert.alert('Erro', 'Erro ao conectar com o servidor.');
        }
        setSaving(false);
    };

    if (loading) {
        return (
            <View style={styles.centered}>
                <ActivityIndicator size="large" color="#2196F3" />
            </View>
        );
    }

    if (!profile) {
        return (
            <View style={styles.centered}>
                <Text>Perfil não encontrado.</Text>
            </View>
        );
    }

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Editar Perfil</Text>
            <Text style={styles.label}>Nome</Text>
            <TextInput
                style={styles.input}
                value={profile.name}
                onChangeText={name => setProfile({ ...profile, name })}
                placeholder="Seu nome"
            />
            <Text style={styles.label}>Email</Text>
            <TextInput
                style={styles.input}
                value={profile.email}
                onChangeText={email => setProfile({ ...profile, email })}
                placeholder="Seu email"
                keyboardType="email-address"
                autoCapitalize="none"
            />
            <Text style={styles.label}>Id do Dispositivo</Text>
            <TextInput
                style={styles.input}
                value={profile.deviceId}
                onChangeText={deviceId => setProfile({ ...profile, deviceId })}
                placeholder="Seu ID do Dispositivo"
                keyboardType="default"
            />
            <TouchableOpacity style={styles.button} onPress={handleSave} disabled={saving}>
                {saving ? <ActivityIndicator color="#fff" /> : <Text style={styles.buttonText}>Salvar</Text>}
            </TouchableOpacity>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 24,
        backgroundColor: '#fff',
    },
    centered: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
    title: {
        fontSize: 26,
        fontWeight: 'bold',
        marginBottom: 32,
        color: '#2196F3',
        alignSelf: 'center',
    },
    label: {
        fontSize: 16,
        color: '#333',
        marginBottom: 6,
        marginTop: 16,
    },
    input: {
        borderWidth: 1,
        borderColor: '#bbb',
        borderRadius: 8,
        padding: 12,
        fontSize: 16,
        backgroundColor: '#f9f9f9',
    },
    button: {
        marginTop: 32,
        backgroundColor: '#2196F3',
        padding: 16,
        borderRadius: 8,
        alignItems: 'center',
        elevation: 2,
    },
    buttonText: {
        color: '#fff',
        fontSize: 18,
        fontWeight: 'bold',
    },
});

export default EditarScreen;