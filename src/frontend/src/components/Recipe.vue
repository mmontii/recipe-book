<template>
    <div class="container-recipe">
        </div>
            <div class="container">
                <div class="recipe-box">
                    <div class="title">
                        <h1>{{ recipe.title }} <button @click="toggleTextField" type="button" class="btn btn-primary btn-sm">
                        <i class="bi bi-pen-fill" style="padding-right: 10px;"></i>Edit Title</button></h1>
                    <div class="edit-title" v-if="showTextField">
                        <input v-model="newTitle" class="form-control" type="text" placeholder="Type new Title.." aria-label="default input example">
                        <button @click="patchTitle" type="button" class="btn btn-success btn-sm">Save</button>
                    </div>
                    <ul>
                        <li class="recipe-info">Meal Type: {{ recipe.type }}</li>
                        <li class="recipe-info">Cuisine: {{ recipe.cuisine }}</li>

                    </ul>
                    </div>
                        <label class="overtext" style="font-weight: bold;">Description</label>
                        <p>{{ recipe.description }}</p>
                </div>


  </div>



</template>

<script> 


export default{
    data(){
        return {
            showTextField: false,
            recipe: {},
            title: null,
            newTitle: null
            
        }
    },
    methods: {
        async loadRecipes(){
            try{
                let response = await this.axios.get('/api/recipe/'+this.$route.params.id)
                this.recipe = response.data
                console.log(response.data)
            } catch(e) {
                console.error(e)
            }
            
        },
        patchTitle(){
            console.log('geklappt')
            this.axios.patch('/api/recipe/'+this.$route.params.id+'?title='+this.newTitle)
            this.$router.go()

            
        },
        toggleTextField() {
      this.showTextField = !this.showTextField;
    }
    }
    ,
    mounted () {
        this.loadRecipes()
    }
}

</script>


<style>
    .recipe-box {
      background-color: #f8f9fa;
      padding: 20px;
      margin: 20px auto;
      width: 80%;
      text-align: left;
    }
    ul {
  list-style: none;
}
.title {
    text-align: center;
}
ul {
    padding-top: 15px;
}
ul li.recipe-info {
    font-size: 1.2rem;
    font-weight:600;
    text-align: center;

}
.edit-title {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 1rem;
}

.edit-title input {
  flex-grow: 1;
  max-width: 67%; 
  margin-right: 1rem;
}


</style>