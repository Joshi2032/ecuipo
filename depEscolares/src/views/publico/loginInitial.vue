<template>
    <div class="center-container">
        <navbarDefault />
        <loginInitial />
    </div>
</template>

<script setup>
import navbarDefault from '@/components/navbarDefault.vue'
import loginInitial from '@/components/loginInitial.vue'
</script>

<style scoped>
.center-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh; /* Ocupa toda la altura de la ventana */
    margin: 0;
}
</style>