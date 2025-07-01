import React, { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Image, TextInput } from 'react-native';
import { Ionicons, MaterialIcons } from '@expo/vector-icons';
import { useNavigation } from '@react-navigation/native';
import type { NativeStackNavigationProp } from '@react-navigation/native-stack';

// Define your stack param list with the available routes
type RootStackParamList = {
    Camera: undefined;
    RegistrarArea: undefined;
    Notificacoes: undefined;
    Perfil: undefined;
    Historico: undefined;
    Semaforo: undefined;
};


const HomeScreen: React.FC = () => {
    const navigation = useNavigation<NativeStackNavigationProp<RootStackParamList>>();
    const [from, setFrom] = useState('');
    const [to, setTo] = useState('');

    return (
        <View style={styles.container}>
            {/* Header com ícone de notificações */}
            <View style={styles.header}>
                <Text style={styles.title}>SafeCross</Text>
                <TouchableOpacity
                    onPress={() => navigation.navigate('Notificacoes')}
                    style={styles.iconButton}
                >
                    <Ionicons name="notifications-outline" size={28} color="#333" />
                </TouchableOpacity>
            </View>

            {/* Inputs de rota */}
            <View style={styles.routeInputsContainer}>
                <View style={{ flexDirection: 'row', alignItems: 'center', backgroundColor: '#fff', borderRadius: 14, borderWidth: 1, borderColor: '#c8e6e0', marginBottom: 8 }}>
                    <Ionicons name="location-outline" size={22} color="#1abc9c" style={{ marginLeft: 12, marginRight: 8 }} />
                    <TextInput
                        style={[styles.routeInput, { flex: 1, borderWidth: 0, marginBottom: 0, paddingLeft: 0 }]}
                        placeholder="Partida"
                        value={from}
                        onChangeText={setFrom}
                    />
                </View>
                <View style={{ flexDirection: 'row', alignItems: 'center', backgroundColor: '#fff', borderRadius: 14, borderWidth: 1, borderColor: '#c8e6e0', marginBottom: 8 }}>
                    <Ionicons name="location-outline" size={22} color="#1abc9c" style={{ marginLeft: 12, marginRight: 8 }} />
                    <TextInput
                        style={[styles.routeInput, { flex: 1, borderWidth: 0, marginBottom: 0, paddingLeft: 0 }]}
                        placeholder="Destino"
                        value={to}
                        onChangeText={setTo}
                    />
                </View>
            </View>

            {/* Mapa top view (placeholder) */}
            <View style={styles.mapContainer}>
                    <Image
                        source={require('../assets/map.gif')}
                        style={{ width: '100%', height: '100%', borderRadius: 18 }}
                        resizeMode="cover"
                    />
            </View>



            <View style={styles.bottomBar}>
                <TouchableOpacity
                    onPress={() => navigation.navigate('RegistrarArea')}
                >
                    <MaterialIcons name="report-problem" size={28} color="#1abc9c" />
                </TouchableOpacity>
                <TouchableOpacity
                    onPress={() => navigation.navigate('Semaforo')}
                >
                    <MaterialIcons name="traffic" size={28} color="#1abc9c" />
                </TouchableOpacity>
                <TouchableOpacity
                    onPress={() => navigation.navigate('Camera')}
                >
                    <MaterialIcons name="camera-alt" size={28} color="#1abc9c" />
                </TouchableOpacity>
                <TouchableOpacity
                    onPress={() => navigation.navigate('Historico')}
                >
                    <Ionicons name="time-outline" size={28} color="#1abc9c" />
                </TouchableOpacity>
                <TouchableOpacity
                    onPress={() => navigation.navigate('Perfil')}
                >
                    <Ionicons name="person-circle-outline" size={28} color="#1abc9c" />
                </TouchableOpacity>
            </View>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#eaf6f3', // tom verde-água claro do fundo da imagem
        paddingTop: 40,
    },
    header: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        paddingHorizontal: 24,
        marginBottom: 10,
    },
    title: {
        fontSize: 26,
        fontWeight: 'bold',
        color: '#1abc9c',
        letterSpacing: 1,
    },
    iconButton: {
        padding: 8,
        backgroundColor: '#fff',
        borderRadius: 16,
        elevation: 2,
        shadowColor: '#1abc9c',
        shadowOpacity: 0.10,
        shadowRadius: 6,
        shadowOffset: { width: 0, height: 2 },
    },
    routeInputsContainer: {
        marginHorizontal: 24,
        marginBottom: 8,
        marginTop: 4,
    },
    routeInput: {
        backgroundColor: '#fff',
        borderRadius: 14,
        paddingHorizontal: 16,
        paddingVertical: 12,
        fontSize: 16,
        color: '#222',
        marginBottom: 8,
        borderWidth: 1,
        borderColor: '#c8e6e0',
    },
    mapContainer: {
        flex: 1,
        marginHorizontal: 16,
        marginTop: 8,
        marginBottom: 18,
        borderRadius: 35,
        backgroundColor: '#fff',
        justifyContent: 'center',
        alignItems: 'center',
        elevation: 6,
        shadowColor: '#1abc9c',
        shadowOpacity: 0.10,
        shadowRadius: 16,
        shadowOffset: { width: 0, height: 6 },
        height: 100,
        overflow: 'hidden'
    },
    bottomBar: {
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'center',
        paddingVertical: 28,
        borderTopWidth: 0,
        backgroundColor: '#fff',
        borderTopLeftRadius: 28,
        borderTopRightRadius: 28,
        elevation: 16,
        shadowColor: '#1abc9c',
        shadowOpacity: 0.12,
        shadowRadius: 18,
        shadowOffset: { width: 0, height: -6 },
    },
    barText: {
        fontSize: 13,
        color: '#1abc9c',
        textAlign: 'center',
        marginTop: 2,
        fontWeight: 'bold',
    },
    card: {
        backgroundColor: '#fff',
        borderRadius: 24,
        padding: 18,
        marginVertical: 8,
        marginHorizontal: 16,
        elevation: 3,
        shadowColor: '#1abc9c',
        shadowOpacity: 0.08,
        shadowRadius: 8,
        shadowOffset: { width: 0, height: 2 },
    },
});

export default HomeScreen;