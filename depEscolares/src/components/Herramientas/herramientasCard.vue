<template>
  <div class="herramienta-card">
    <img :src="imagen" :alt="nombre" class="herramienta-imagen" />
    <h2 class="herramienta-nombre">{{ nombre }}</h2>
    <div class="herramienta-botones">
      <button @click="verDetalles" class="btn-detalles">Ver Detalles</button>
      <button @click="solicitarPrestamo" class="btn-prestamo">Solicitar Préstamo</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "HerramientaCard",
  props: {
    imagen: {
      type: String,
      required: true,
    },
    nombre: {
      type: String,
      required: true,
    },
  },
  methods: {
    verDetalles() {
      this.$emit("ver-detalles", this.nombre);
    },
    solicitarPrestamo() {
      this.$emit("solicitar-prestamo", this.nombre);
    },
  },
};
</script>

<style scoped>
.herramienta-card {
  background: linear-gradient(90deg, #2196f3, #21cbf3);
  border-radius: 8px;
  padding: 16px;
  text-align: center;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: transform 0.2s ease-in-out;
}

.herramienta-card:hover {
  transform: scale(1.05);
}

.herramienta-imagen {
  width: 100%;
  max-width: 150px;
  height: auto;
  margin: 0 auto 16px;
  border-radius: 8px;
}

.herramienta-nombre {
  font-size: 1.2rem;
  font-weight: bold;
  color: #fff;
  margin-bottom: 16px;
}

.herramienta-botones {
  display: flex;
  justify-content: center;
  gap: 8px;
}

button {
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 0.9rem;
  font-weight: bold;
  transition: background-color 0.2s ease-in-out;
}

.btn-detalles {
  background-color: #1976d2;
  color: #fff;
}

.btn-detalles:hover {
  background-color: #1565c0;
}

.btn-prestamo {
  background-color: #64b5f6;
  color: #fff;
}

.btn-prestamo:hover {
  background-color: #42a5f5;
}

/* Responsivo */
@media (max-width: 768px) {
  .herramienta-card {
    padding: 12px;
  }

  .herramienta-nombre {
    font-size: 1rem;
  }

  button {
    font-size: 0.8rem;
    padding: 6px 12px;
  }
}
</style>