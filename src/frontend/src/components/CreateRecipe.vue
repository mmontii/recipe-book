<template>
    <div class="container">

        <div class="form-create-recipe">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label" >Recipe Title</label>
                <input v-model="title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="type recipe title..">
            </div>

            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Meal Type</label>
                <input v-model="type" type="text" class="form-control" id="exampleFormControlInput1" placeholder="type meal type..">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Cuisne</label>
                <input v-model="cuisine" type="text" class="form-control" id="exampleFormControlInput1" placeholder="type cuisne..">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label" >Description</label>
                <textarea v-model="description" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
                        


            <button type="button" class="btn btn-success" v-on:click="postRecipe " >Add Recipe</button>


        </div>




    </div>


    
</template>


<script>


export default {
    data() {
        return {
            title:null,
            type:null,
            cuisine:null,
            description:null
        }
    },


    methods: {

        postRecipe() {
            console.log("button clicked")
            
    
            this.axios.post('/api/recipe', {
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

        },

    }
}


</script>


<style>

.form-label {
    display: fle;
    align-items: center;
}

.form-create-recipe {

    margin-top: 100px;
    width: 300px;

}

</style>