import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, FlatList, TouchableOpacity, Alert, Platform } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import { useNavigation } from '@react-navigation/native';
import axios from 'axios';
import AsyncStorage from '@react-native-async-storage/async-storage';


      const BASE_URL =
        Platform.OS === 'android' ? 'http://10.0.2.2:8082' : 'http://localhost:8082';


type RootStackParamList = {
    Home: undefined;
};

type Notificacao = {
    id: number;
    notificationTypeId: number;
    notificationTypeDescription: string;
    sentDateTime: string;
    targetLatitude?: number;
    targetLongitude?: number;
    descricao?: string; // compatibilidade
    data?: string;      // compatibilidade
};

const tipoNotificacao: Record<number, string> = {
    1: 'Alerta de Segurança',
    2: 'Informativo',
    3: 'Aviso',
    // Adicione outros tipos conforme necessário
};

const NotificacoesScreen: React.FC = () => {
    const navigation = useNavigation<import('@react-navigation/native').NavigationProp<RootStackParamList>>();
    const [notificacoes, setNotificacoes] = useState<Notificacao[]>([]);

    useEffect(() => {
        const fetchUserIdAndNotificacoes = async () => {
            const storedUserId = await AsyncStorage.getItem('userId');
            try {
                if (storedUserId) {
                    const response = await axios.get(`${BASE_URL}/safecross/v1/notifications/${storedUserId}`);
                    setNotificacoes(response.data);
                }
            } catch (error) {
                console.error('Erro ao buscar notificações:', error);
            }
        };
        fetchUserIdAndNotificacoes();
    }, []);

    const limparTodas = () => {
        const fetchClear = async () => {

            const storedUserId = await AsyncStorage.getItem('userId');

            try {
                const notificacoesClear = await axios.delete(`${BASE_URL}/safecross/v1/notifications/${storedUserId}`);
                if (notificacoesClear.status === 200) {
                    console.log('Notificações limpas com sucesso');
                    Alert.alert('Notificações limpas');
                }
                else {
                    Alert.alert('Erro', 'Falha ao limpar notificações. Tente novamente.');
                }
            } catch (error) {
                Alert.alert('Erro', 'Falha ao limpar notificações. Tente novamente.');
                console.error('Erro ao limpar notificações:', error);
            }
        };
        fetchClear();
        setNotificacoes([]);
    };

    // Agrupa notificações por tipo
    const notificacoesPorTipo = notificacoes.reduce((acc, noti) => {
        const tipo = noti.notificationTypeId ?? noti.id_tipo_notificacao;
        if (!acc[tipo]) acc[tipo] = [];
        acc[tipo].push(noti);
        return acc;
    }, {} as Record<number, Notificacao[]>);

    return (
        <View style={styles.container}>
            <View style={styles.header}>
                <TouchableOpacity onPress={() => navigation.navigate('Home')}>
                    <Ionicons name="arrow-back" size={28} color="#1976d2" />
                </TouchableOpacity>
                <Text style={styles.title}>Notificações</Text>
                <TouchableOpacity onPress={limparTodas}>
                    <Ionicons name="trash-outline" size={26} color="#f44336" />
                </TouchableOpacity>
            </View>
            {notificacoes.length === 0 ? (
                <View style={styles.emptyBox}>
                    <Text style={styles.emptyText}>Nenhuma notificação.</Text>
                </View>
            ) : (
                <FlatList
                    data={Object.keys(notificacoesPorTipo)}
                    keyExtractor={tipo => tipo}
                    renderItem={({ item: tipo }) => (
                        <View>
                            <Text style={styles.sectionTitle}>
                                {tipoNotificacao[Number(tipo)] || 'Outro'}
                            </Text>
                            {notificacoesPorTipo[Number(tipo)].map(noti => (
                                <View style={styles.notificationBox} key={noti.id}>
                                    <Text style={styles.descTipo}>
                                        {noti.notificationTypeDescription || tipoNotificacao[noti.notificationTypeId] || 'Outro'}
                                    </Text>
                                    <Text style={styles.desc}>
                                        {noti.descricao || noti.notificationTypeDescription}
                                    </Text>
                                    <Text style={styles.date}>
                                        {noti.sentDateTime
                                            ? new Date(noti.sentDateTime).toLocaleString('pt-BR')
                                            : noti.data}
                                    </Text>
                                </View>
                            ))}
                        </View>
                    )}
                />
            )}
        </View>
    );
};

const styles = StyleSheet.create({
    container: { 
        flex: 1, 
        backgroundColor: '#eaf6f3',
        padding: 24,
        top: 40
    },
    header: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        paddingHorizontal: 16,
        marginBottom: 10,
    },
    title: { 
        fontSize: 22, 
        fontWeight: 'bold', 
        color: '#1abc9c'
    },
    notificationBox: {
        backgroundColor: '#fff',
        marginHorizontal: 16,
        marginVertical: 6,
        borderRadius: 20,
        padding: 14,
        elevation: 3,
        shadowColor: '#1abc9c',
        shadowOpacity: 0.10,
        shadowRadius: 8,
        shadowOffset: { width: 0, height: 2 },
    },
    desc: { 
        fontSize: 16, 
        color: '#1976d2'
    },
    date: { 
        fontSize: 13, 
        color: '#1abc9c', 
        marginTop: 4 
    },
    emptyBox: { 
        flex: 1, 
        justifyContent: 'center', 
        alignItems: 'center' 
    },
    emptyText: { 
        color: '#b0bec5', 
        fontSize: 16 
    },
    descTipo: {
        fontWeight: 'bold',
        color: '#1abc9c',
        marginBottom: 4,
    },
    sectionTitle: {
        fontSize: 18,
        fontWeight: 'bold',
        color: '#1976d2',
        marginTop: 16,
        marginBottom: 8,
        marginLeft: 8,
    },
});

export default NotificacoesScreen;