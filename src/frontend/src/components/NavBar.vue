<template>
<nav class="nav justify-content-center" style="background-color: #ffbf0f;">

  <li class="nav-item">
    <i class="bi bi-bookmarks-fill" style="margin-right: 5px;"></i>    
    <router-link :to="{name: 'go-library' }" style="text-decoration: none; color: inherit;">Library</router-link>
  </li>
   <li class="nav-item">
    <button type="button" class="btn btn-success"><router-link :to="{name: 'go-create' }" style="text-decoration: none; color: inherit;">Create New Recipe</router-link></button>
  </li> 
  <li class="nav-item">
    <i class="bi bi-chat-heart-fill" style="margin-right: 5px;"></i>
    <router-link class="routes" :to="{name: 'go-about' }" style="text-decoration: none; color: inherit;">About Page</router-link>
  </li>
</nav>
</template>

<script>
</script>
