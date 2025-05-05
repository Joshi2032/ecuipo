<template>
  <nav class="navbar">
    <div class="navbar-container">
      <!-- Logotipo -->
      <div class="logo">
        <img src="@/assets/tecnm.png" alt="Logo" />
      </div>

      <!-- Barra de búsqueda -->
      <div class="search-bar">
        <input type="text" placeholder="Buscar..." v-model="searchQuery" />
        <button @click="onSearch">🔍</button>
      </div>

      <!-- Ícono de login -->
      <div class="login-icon">
        <button @click="onLogin">
          <img src="@/assets/login-icon.png" alt="Login" />
        </button>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      searchQuery: "",
    };
  },
  methods: {
    onSearch() {
      console.log("Buscando:", this.searchQuery);
      // Lógica adicional para manejar la búsqueda
    },
    onLogin() {
      console.log("Login clickeado");
      // Lógica adicional para manejar el login
    },
  },
};
</script>

<style scoped>
.navbar {
  background: linear-gradient(90deg, #2196f3, #21cbf3);
  padding: 10px 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.navbar-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  max-width: 1200px;
}

.logo img {
  height: 40px;
}

.search-bar {
  display: flex;
  align-items: center;
  flex: 1;
  margin: 0 20px;
}

.search-bar input {
  flex: 1;
  padding: 8px 12px;
  border: none;
  border-radius: 4px;
  outline: none;
}

.search-bar button {
  margin-left: 8px;
  padding: 8px 12px;
  background-color: #ffffff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.search-bar button:hover {
  background-color: #f0f0f0;
}

.login-icon button {
  background: none;
  border: none;
  cursor: pointer;
}

.login-icon img {
  height: 30px;
}

@media (max-width: 768px) {
  .navbar-container {
    flex-direction: column;
  }

  .search-bar {
    margin: 10px 0;
    width: 100%;
  }

  .search-bar input {
    width: 100%;
  }
}
</style>