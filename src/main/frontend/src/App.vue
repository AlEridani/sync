<template>
  <div class="flex h-screen">
    <!-- 코드 내용 -->
    <table>
      <thead>
      <tr>
        <th> name </th>
        <th> size </th>
        <th> type </th>
        <th> date </th>
        <th> action </th>
      </tr>
      </thead>
      <tbody>
     <!-- 파일 목록 표시 -->
      <tr v-for="(item, index) in items" :key="index">
        <td>{{ item.name }}</td>
        <td>{{ item.size }}</td>
        <td>{{ item.type }}</td>
        <td>{{ item.created }}</td>
        <td>
          <!-- action buttons -->
          <button @click="editItem(item)">Edit</button>
          <button @click="deleteItem(item)">Delete</button>
          <button @click="downloadItem(item)">Download</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      items: [] // 서버에서 가져온 파일 목록 데이터
    };
  },
  methods: {
    getFiles() {
      axios.get('http://localhost:8080/syc/api/file-list')
          .then(response => {
            this.files = response.data;
          })
          .catch(error => {
            console.error("There was an error fetching the files:", error);
          });
    }
  },
  mounted() {
    // 서버에서 파일 목록 가져오기
    this.getFiles();
  }
};
</script>

<style scoped>
/* CSS 스타일 */

</style>
