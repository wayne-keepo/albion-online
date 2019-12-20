<template>
  <div id="app">
    <TableSheet/>
  </div>
</template>

<script>
import TableSheet from './views/TableSheet'

export default {
  name: 'app',
  components: {
    TableSheet
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
