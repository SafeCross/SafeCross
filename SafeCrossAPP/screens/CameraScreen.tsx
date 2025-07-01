import React, { useEffect, useRef, useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, ActivityIndicator, Image } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import { useNavigation } from '@react-navigation/native';
import type { NativeStackNavigationProp } from '@react-navigation/native-stack';

type RootStackParamList = {
  // Define your navigation params here, e.g.:
  Home: undefined;
  // Camera: undefined;
};
// import { Camera, useCameraDevices, VideoFile } from 'react-native-vision-camera';
// import { useCameraPermission } from 'react-native-vision-camera';

export default function CameraScreen() {
  const navigation = useNavigation<NativeStackNavigationProp<RootStackParamList>>();
  //   const cameraRef = useRef<Camera>(null);
  //   const { hasPermission, requestPermission } = useCameraPermission();
  //   const [permissionChecked, setPermissionChecked] = useState(false);
  //   const [videoUri, setVideoUri] = useState<string | null>(null);
  //   const [isRecording, setIsRecording] = useState(false);
  //   const RECORD_DURATION = 10000;

  //   useEffect(() => {
  //     (async () => {
  //       const status = await requestPermission();
  //       setPermissionChecked(true);
  //     })();
  //   }, []);

  //   const devices = useCameraDevices();
  //   const device = devices.back;

  //   if (!permissionChecked) {
  //     return (
  //       <View style={styles.centered}>
  //         <Text style={styles.text}>Verificando permissões...</Text>
  //       </View>
  //     );
  //   }

  //   if (!hasPermission) {
  //     return (
  //       <View style={styles.centered}>
  //         <Text style={styles.text}>Permissão da câmera negada.</Text>
  //       </View>
  //     );
  //   }

  //   if (device == null) {
  //     return (
  //       <View style={styles.centered}>
  //         <Text style={styles.text}>Nenhuma câmera disponível.</Text>
  //       </View>
  //     );
  //   }

  return (
    <View style={styles.fullContainer}>
      <Image
        source={require('../assets/cam.gif')}
        style={styles.fullImage}
        accessible
        accessibilityLabel="Demonstração da câmera"
      />
      <View style={styles.overlay}>
        <TouchableOpacity
          onPress={() => navigation.navigate('Home')}
          style={styles.backButton}
          accessibilityLabel="Voltar para a Home"
        >
          <Ionicons name="arrow-back-circle" size={44} color="#fff" />
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#000' },
  centered: { flex: 1, justifyContent: 'center', alignItems: 'center' },
  text: { color: '#fff' },
  fullContainer: { flex: 1, backgroundColor: '#000' },
  fullImage: { flex: 1, width: '100%', height: '100%', resizeMode: 'cover' },
  overlay: {
    position: 'absolute',
    top: 40,
    left: 0,
    right: 0,
    alignItems: 'flex-start',
    paddingLeft: 16,
  },
  backButton: {
    backgroundColor: 'rgba(0,0,0,0.3)',
    borderRadius: 22,
  },
  textOverlay: {
    color: '#fff',
    fontSize: 18,
    backgroundColor: 'rgba(0,0,0,0.5)',
    paddingHorizontal: 16,
    paddingVertical: 8,
    borderRadius: 8,
  },
});
