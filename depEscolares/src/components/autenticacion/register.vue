<template>
  <div class="register-container">
    <form @submit.prevent="handleSubmit" class="register-form">
      <h2>Registro</h2>
      <div class="form-group">
        <label for="name">Nombre</label>
        <input type="text" id="name" v-model="form.name" placeholder="Ingresa tu nombre" required />
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" v-model="form.email" placeholder="Ingresa tu email" required />
      </div>
      <div class="form-group">
        <label for="password">Contraseña</label>
        <input type="password" id="password" v-model="form.password" placeholder="Ingresa tu contraseña" required />
      </div>
      <button type="submit">Registrarse</button>
    </form>
  </div>
</template>

<script>
import apiService from "@/services/apiService"; // Asegúrate de tener un servicio API configurado
import { useRouter } from "vue-router"; // Asegúrate de usar vue-router para redirección

export default {
  data() {
    return {
      form: {
        name: "",
        email: "",
        password: "",
      },
    };
  },
  methods: {
    handleSubmit() {
      apiService
        .register(this.form)
        .then((response) => {
          console.log("Usuario registrado exitosamente:", response.data);
          // Redirigir al dashboard o mostrar mensaje
          this.$router.push("/dashboard-alumno"); // o donde desees redirigir
        })
        .catch((error) => {
          console.error("Error al registrar el usuario:", error);
          alert("No se pudo registrar el usuario. Intenta de nuevo.");
        });
    },
  },
};
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(90deg, #2196f3, #21cbf3);
  padding: 20px;
  box-sizing: border-box;
}

.register-form {
  background: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 400px;
}

.register-form h2 {
  margin-bottom: 20px;
  text-align: center;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #2196f3;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #1e88e5;
}

@media (max-width: 600px) {
  .register-form {
    padding: 15px;
  }

  button {
    font-size: 14px;
  }
}
</style>