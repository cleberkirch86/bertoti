<template>
  <div>
    <h1>Estrutura Organizacional</h1>
    <pre>{{ chartData }}</pre>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'EmployeeTree',
  data() {
    return {
      chartData: null
    };
  },
  mounted() {
    axios.get('http://localhost:8081/api/empregados')
      .then(response => {
        this.chartData = response.data;
      });
  }
};
</script>
