<template>
    <div class="main_resources">
        <div class="gather_resources">
            <GatherResources/>
        </div >
        <div class="food_resources">
            <FoodResources/>
        </div>
        <div class="alchemy_resources">
            <AlchemyResources/>
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
            mLoading: true,
            fLoading: true,
            aLoading: true
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