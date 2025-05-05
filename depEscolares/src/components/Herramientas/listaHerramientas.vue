<template>
    <h1 class="titulo">Lista de Herramientas</h1>
  <div class="lista-herramientas">
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
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 100%;
  max-width: 800px;
  padding: 20px;
  color: white;
  min-height: 100vh;
  box-sizing: border-box;
}

.titulo {
  position: absolute;
  top: 12%; /* Ajustado para estar un 25% más abajo */
  left: 20px;
  margin: 0;
  font-size: 24px;
  color: white;
}

.herramientas-container {
  display: flex; /* Usar flexbox */
  flex-wrap: wrap; /* Permitir que las tarjetas se ajusten a nuevas filas */
  justify-content: center; /* Centrar las tarjetas horizontalmente */
  gap: 20px; /* Espaciado entre las tarjetas */
}

.herramienta-card {
  background: rgba(255, 255, 255, 0.2);
  padding: 15px;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  text-align: center;
  flex: 1 1 calc(25% - 20px); /* Cada tarjeta ocupa un 25% del ancho menos el espacio del gap */
  max-width: calc(25% - 20px); /* Limitar el ancho máximo a 25% menos el gap */
  box-sizing: border-box; /* Asegurar que el padding no afecte el ancho */
}

.herramienta-card h2 {
  margin-bottom: 10px;
}

.herramienta-card p {
  font-size: 14px;
}
</style>