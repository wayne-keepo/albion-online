<template>
    <div>
        <table>
            <tr>
                <th>Тир</th>
                <th>Брус</th>
                <th>Слитки</th>
                <th>Кожа</th>
                <th>Ткань</th>
            </tr>
            <tr v-for="resource in resources.planks" :key="resource.tier">
                <td>{{resource.tier}}</td>
                <td>{{resource.price_plnks}}</td>
                <td>{{resource.price_metalbars}}</td>
                <td>{{resource.price_leathers}}</td>
                <td>{{resource.price_cloth}}</td>
            </tr>
        </table>

    </div>

</template>

<script>
    export default {
        name: "GatherResources",
        data(){
            return {
                resources: []
            }
        }
    }
</script>

<style scoped>

</style>