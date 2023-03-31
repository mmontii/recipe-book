import { createRouter, createWebHistory } from 'vue-router'
import CreateView from '@/view/CreateView.vue'
import LibraryView from '@/view/LibraryView.vue'
import AboutView from '@/view/AboutView.vue'
import Recipe from '@/components/Recipe.vue'
import EditRecipe from '@/components/EditRecipe.vue'


const routes = [
    {path: '/',name: "go-library", component: LibraryView},
    {path: '/library',name: "go-library", component: LibraryView},
    {path: '/create', name: "go-create",component: CreateView},
    {path: '/about', name: "go-about",component: AboutView},
    {path: '/recipe/:id', name: "go-recipe",component: Recipe},
    {path: '/edit/:id', name: "go-edit",component: EditRecipe},



]

const router = createRouter( {
    history: createWebHistory(),
    routes
})

export default router