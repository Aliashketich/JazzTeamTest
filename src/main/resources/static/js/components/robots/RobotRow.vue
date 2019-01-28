<template>
    <td>
        <i>№{{robot.id}}</i>
        {{robot.name}}
        {{robot.type}}
        {{robot.status}}
    </td>
</template>

<script>
    export default {
        props: ['robot']
    }
</script>

<style>

</style>