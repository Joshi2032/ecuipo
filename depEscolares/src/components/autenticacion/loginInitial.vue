<template>
  <div class="login-initial">
    <div class="content">
      <h1>Bienvenido a Escolares</h1>
      <p>¿Qué deseas hacer?</p>
      <div class="buttons">
        <button @click="navigateTo('login')">Iniciar Sesión</button>
        <button @click="navigateTo('register')">Registrarte</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginInitial",
  methods: {
    navigateTo(route) {
      this.$router.push({ name: route });
    },
  },
};
</script>

<style scoped>
.login-initial {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(90deg, #2196f3, #21cbf3);
  color: white;
  text-align: center;
}

.content {
  max-width: 400px;
  padding: 20px;
  background: rgba(255, 255, 255, 0.1);
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

h1 {
  font-size: 2rem;
  margin-bottom: 1rem;
}

p {
  font-size: 1.2rem;
  margin-bottom: 2rem;
}

.buttons {
  display: flex;
  gap: 10px;
  flex-wrap: wrap;
  justify-content: center;
}

button {
  padding: 10px 20px;
  font-size: 1rem;
  color: #2196f3;
  background: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background 0.3s, transform 0.2s;
}

button:hover {
  background: #e3f2fd;
  transform: scale(1.05);
}

@media (max-width: 600px) {
  h1 {
    font-size: 1.5rem;
  }

  p {
    font-size: 1rem;
  }

  button {
    font-size: 0.9rem;
    padding: 8px 16px;
  }
}
</style>