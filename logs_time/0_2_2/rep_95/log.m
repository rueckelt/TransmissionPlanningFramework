% t_n_i
% time:
generate_model = 3735;
duration_to_solve_model_us = 745;
create_model = 23;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0];
allocatedChunks(:,:,2) = [3, 0, 0, 0; 3, 0, 0, 0; 3, 0, 0, 0; 3, 0, 0, 0; 3, 0, 0, 0; 3, 0, 0, 0; 0, 0, 17, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
allocatedChunks(:,:,3) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 4; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 8, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
allocatedChunks(:,:,4) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 34; 0, 21, 0, 0; 0, 34, 0, 0; 0, 34, 0, 0; 0, 34, 0, 0; 0, 34, 0, 0; 0, 34, 0, 0; 0, 34, 0, 0; 0, 21, 0, 0; 21, 0, 0, 0; 16, 0, 0, 0; 16, 0, 0, 0];
% non_allocated
non_allocated = [45, 0, 0, 117];
% dl_vio
dl_vio = [0, 0, 0, 0];
% st_vio
st_vio = [0, 0, 0, 1806];
% vioThroughput
vioThroughput = [0, 0, 0, 0];
% non_allo_vio
non_allo_vio = [2520, 0, 0, 4914];
% nChunks
nChunks = [170, 35, 12, 450];
% prefStartTime
prefStartTime = [0, 6, 0, 18];
% deadline
deadline = [34, 7, 100000, 48];
% availBW
availBW = [21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 26, 39, 39, 39, 39, 39, 39, 26, 13, 0, 0; 0, 0, 0, 0, 0, 0, 22, 44, 44, 44, 44, 44, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 13, 26, 39, 39, 39, 39, 39, 39, 26, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0];
