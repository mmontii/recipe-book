<template>

<div class="container">

<div class="form-create-recipe">
    
    <div class="mb-3">
        <div class="alert alert-primary" role="alert" style="font-weight: bolder;">
            Old Recipe Titel:{{ recipe.title }}
        </div>
        <label for="exampleFormControlInput1" class="form-label" style="font-weight: bolder;">Recipe Title: </label>
        <input v-model="title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="type new recipe title..">
    </div>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label" style="font-weight: bolder;">Meal Type</label>
        <input v-model="type" type="text" class="form-control" id="exampleFormControlInput1" placeholder="type new meal type..">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label" style="font-weight: bolder;">Cuisne</label>
        <input v-model="cuisine" type="text" class="form-control" id="exampleFormControlInput1" placeholder="type new cuisne of recipe..">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label" style="font-weight: bolder;">Description</label>
        <textarea v-model="description"  class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
                


    <button type="button" class="btn btn-primary btn-sm" v-on:click="putRecipe" >Edit Recipe</button>


</div>




</div>



</template>



<script>

export default{

    data(){
        return {
            recipe: {},
            id:this.$route.params.id,
            title:null,
            type:null,
            cuisine:null,
            description:null
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
        putRecipe(){
            console.log("button clicked")

            this.axios.put('/api/recipe', {
                id: this.id,
                title: this.title,
                type: this.type,
                cuisine: this.cuisine,
                description: this.description
            })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error)
            })

            alert("Recipe was added!")

            this.$router.go()


        }
    }
    ,
    mounted () {
        this.loadRecipes()
    }
}

</script>


<style>




html, body {
  height: 100%;
}

.form-create-recipe {
  height: 100%;
}

</style>