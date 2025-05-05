import axios from "axios";

const api = axios.create({
    baseURL: "http://localhost:8080/api", // Cambia al URL de tu backend
});

export default {
    // Método para obtener todos los usuarios
    getusuarios() {
        return api.get("/usuarios");
    },
    // Método para login de un usuario
    iniciarSesion(email, password) {
        return api.post("/login", { email, password });
    },
    // Registrar usuarios
    register(userData) {
        return api.post("/usuarios", userData);
    }
}