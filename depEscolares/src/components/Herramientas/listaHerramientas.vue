<template>
  <div class="lista-herramientas">
    <h1 class="titulo">Lista de Herramientas</h1>
    <div class="herramientas-container">
      <div 
        v-for="herramienta in herramientas" 
        :key="herramienta.id" 
        class="herramienta-card"
      >
        <h2>{{ herramienta.nombre }}</h2>
        <p>{{ herramienta.descripcion }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ListaHerramientas",
  data() {
    return {
      herramientas: [
        { id: 1, nombre: "Herramienta 1", descripcion: "Descripción de la herramienta 1" },
        { id: 2, nombre: "Herramienta 2", descripcion: "Descripción de la herramienta 2" },
        { id: 3, nombre: "Herramienta 3", descripcion: "Descripción de la herramienta 3" },
        // Agrega más herramientas según sea necesario
      ],
    };
  },
};
</script>

<style scoped>
.lista-herramientas {
  background: linear-gradient(90deg, #2196f3, #21cbf3);
  padding: 20px;
  color: white;
  min-height: 100vh;
}

.titulo {
  text-align: center;
  margin-bottom: 20px;
}

.herramientas-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
}

.herramienta-card {
  background: rgba(255, 255, 255, 0.2);
  padding: 15px;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.herramienta-card h2 {
  margin-bottom: 10px;
}

.herramienta-card p {
  font-size: 14px;
}
</style>