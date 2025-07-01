import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, FlatList, TouchableOpacity } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import { useNavigation } from '@react-navigation/native';

type RootStackParamList = {
    Home: undefined;
};

import type { StackNavigationProp } from '@react-navigation/stack';

// Dados mockados para exemplo (substitua por dados da API)
const MOCK_HISTORICO = [
    { id: '1', tipo: 'Área registrada', detalhe: 'Rua das Flores', data: '2024-06-01 14:30' },
    { id: '2', tipo: 'Visualização', detalhe: 'Câmera RA', data: '2024-06-01 13:10' },
    { id: '3', tipo: 'Sincronização', detalhe: 'Dados sincronizados', data: '2024-06-01 12:00' },
];

const HistoricoScreen: React.FC = () => {
    const navigation = useNavigation<StackNavigationProp<RootStackParamList, 'Home'>>();
    const [historico, setHistorico] = useState(MOCK_HISTORICO);

    useEffect(() => {
    }, []);

    return (
        <View style={styles.container}>
            <View style={styles.header}>
                <TouchableOpacity onPress={() => navigation.navigate('Home')}>
                    <Ionicons name="arrow-back" size={28} color="#1976d2" />
                </TouchableOpacity>
                <Text style={styles.title}>Histórico</Text>
                <View style={{ width: 28 }} />
            </View>
            {historico.length === 0 ? (
                <View style={styles.emptyBox}>
                    <Text style={styles.emptyText}>Nenhum histórico encontrado.</Text>
                </View>
            ) : (
                <FlatList
                    data={historico}
                    keyExtractor={item => item.id}
                    renderItem={({ item }) => (
                        <View style={styles.itemBox}>
                            <Text style={styles.tipo}>{item.tipo}</Text>
                            <Text style={styles.detalhe}>{item.detalhe}</Text>
                            <Text style={styles.data}>{item.data}</Text>
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
        padding: 16,
        top: 40,
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
        color: '#1abc9c', // verde-água principal
    },
    itemBox: {
        backgroundColor: '#fff',
        marginHorizontal: 16,
        marginVertical: 6,
        borderRadius: 20,
        padding: 16,
        elevation: 3,
        shadowColor: '#1abc9c',
        shadowOpacity: 0.10,
        shadowRadius: 8,
        shadowOffset: { width: 0, height: 2 },
    },
    tipo: {
        fontSize: 16,
        color: '#1976d2', // azul principal dos cards
        fontWeight: 'bold',
        marginBottom: 2,
    },
    detalhe: {
        fontSize: 15,
        color: '#333',
        marginTop: 2,
        marginBottom: 2,
    },
    data: {
        fontSize: 13,
        color: '#1abc9c',
        marginTop: 4,
        fontWeight: 'bold',
    },
    emptyBox: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
    emptyText: {
        color: '#b0bec5',
        fontSize: 16,
    },
});

export default HistoricoScreen;