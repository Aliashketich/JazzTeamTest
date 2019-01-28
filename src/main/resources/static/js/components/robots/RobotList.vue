<template>
    <table>
        <tr>
            <robot-row v-for="robot in robots" :key="robot.id" :robot="robot" />
        </tr>
    </table>
</template>

<script>
    import RobotRow from 'components/robots/RobotRow.vue'
    export default {
        components:{
          RobotRow
        },
        props: ['robots']
    }
</script>

<style>
    td{
        border: 2px solid black;
    }
</style>