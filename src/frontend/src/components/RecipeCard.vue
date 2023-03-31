<template>



<div class="card" style="width: 14rem; " >
  <img src="@/assets/Base.png" class="card-img-top" alt="..." style="margin-top: 5px;">
  <div class="card-body" >
    <h5 class="card-title">{{ title }}</h5>
    <p class="card-text">{{ type }}</p>
    <p class="card-text">{{ cuisine }}</p>
    <div class="card-buttons">
        <button @click="showRecipe" type="button" class="btn btn-info btn-sm">Show</button>
        <button @click="editRecipe" type="button" class="btn btn-primary btn-sm">Edit</button>
        <button @click="deleteRecipe" type="button" class="btn btn-danger btn-sm">Delete</button>

    </div>

  </div>
</div>
</template>

<script>

export default {
 
    props: ["id","title","type","cuisine"]
    ,
    methods: {
        showRecipe() {
            this.$emit('showRecipe',this.id)
        },
        editRecipe() {
            this.$emit('editRecipe',this.id)
        },
        deleteRecipe() {
            this.$emit('deleteRecipe',this.id)
        },
    }
    
}

</script>

<style>
.card {
    margin: 5px;
}

.btn{
    display: inline-block;
    margin: 5px;
}
.card-img-top {
    object-fit: cover;
    width: 100%;
    height: 150px;
}
.card-title{
    white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  max-width: 200px;
}
.card-text {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  max-width: 200px;
}
</style>