<template>
    <div class="container">
        <div class="recipe-container">
            <template v-for="recipe in recipes" v-bind:key="recipe.id" class="recipe">
                <RecipeCard v-bind:title=recipe.title :type=recipe.type :cuisine=recipe.cuisine :id=recipe.id  
                @showRecipe="showListRecipe" @editRecipe="editListRecipe" @deleteRecipe="deleteListRecipe">
                    {{ recipe.title }} {{ recipe.type }} {{ recipe.cuisine }}
                    
                </RecipeCard>
            </template>
        </div>
    </div>
</template>

<script>
import router from '@/router'
import RecipeCard from './RecipeCard.vue'
export default{
    name: 'Recipe-List',
    data: () => ({
        recipes: []

    }),
    components:{

        RecipeCard
    },

    methods: {
        async loadRecipes(){
            try{
                let response = await this.axios.get('/api/recipe')
                this.recipes = response.data
                console.log(response.data)
            } catch(e) {
                console.error(e)
            }
            
        },
        showListRecipe(id) {
            router.push({ path: '/recipe/'+id })
        },
        editListRecipe(id) { // Not working!
            router.push({ path: '/edit/'+id })

        },
        deleteListRecipe(id) {
            this.axios.delete('/api/recipe/'+id)
            this.$router.go()
        },
        
    },
    mounted(){
        this.loadRecipes();
    }
    
}

</script>

