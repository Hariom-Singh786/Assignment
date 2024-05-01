function renderBlocks() {
    const input = document.getElementById('blocksInput').value;
    const blockHeights = JSON.parse(input);
    const maxHeight = Math.max(...blockHeights);
    const table = document.getElementById('blocksTable');
    table.innerHTML = ''; // Clear previous table

    // Create table rows from top to bottom (maxHeight to 0)
    for (let height = maxHeight; height > 0; height--) {
        const row = table.insertRow();
        for (let i = 0; i < blockHeights.length; i++) {
            const cell = row.insertCell();
            if (blockHeights[i] >= height) {
                cell.classList.add('block');
            } else if (isWater(blockHeights, i, height)) {
                cell.classList.add('water');
            }
        }
    }

    const waterStored = calculateWaterStored(blockHeights);
    document.getElementById('waterStored').innerText = `Total water stored: ${waterStored} units`;
}

function isWater(blocks, index, height) {
    const leftMax = Math.max(...blocks.slice(0, index + 1));
    const rightMax = Math.max(...blocks.slice(index));
    return height <= leftMax && height <= rightMax && blocks[index] < height;
}

function calculateWaterStored(blocks) {
    let waterStored = 0;
    for (let i = 0; i < blocks.length; i++) {
        const minBoundaryHeight = Math.min(leftMax(blocks, i), rightMax(blocks, i));
        waterStored += minBoundaryHeight - blocks[i];
    }
    return waterStored;
}

function leftMax(blocks, index) {
    return Math.max(...blocks.slice(0, index + 1));
}

function rightMax(blocks, index) {
    return Math.max(...blocks.slice(index));
}