<template>
    <div class="main_resources">
        <div class="gather_resources">
            <GatherResources/>
            <button>update</button>
        </div >
        <div class="food_resources">
            <FoodResources/>
            <button>update</button>
        </div>
        <div class="alchemy_resources">
            <AlchemyResources/>
            <button>update</button>
        </div>
    </div>
</template>


<script>
    import GatherResources from '@/components/GatherResources';
    import FoodResources from '@/components/FoodResources';
    import AlchemyResources from '@/components/AlchemyResources';

    export default {
        name: "TableSheet",
        data:() => ({

        }),
        components:{
            GatherResources,
            FoodResources,
            AlchemyResources
        }
    }
</script>

<style scoped>
    .main_resources {}
    .gather_resources {}
    .food_resources {}
    .alchemy_resources {}
</style>