% t_n_i
% time:
generate_model = 3334;
duration_to_solve_model_us = 438;
create_model = 25;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0, 0, 0; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 5, 0, 0, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0];
allocatedChunks(:,:,2) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 35; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
allocatedChunks(:,:,3) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 12, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
allocatedChunks(:,:,4) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 15, 0, 0; 0, 65, 0, 0; 0, 65, 0, 0; 0, 65, 0, 0; 0, 65, 0, 0; 39, 0, 0, 0; 34, 0, 0, 0; 34, 0, 0, 0; 34, 0, 0, 0; 34, 0, 0, 0];
% non_allocated
non_allocated = [35, 0, 0, 0];
% dl_vio
dl_vio = [0, 0, 0, 0];
% st_vio
st_vio = [0, 0, 0, 250];
% vioThroughput
vioThroughput = [0, 0, 0, 0];
% non_allo_vio
non_allo_vio = [1960, 0, 0, 0];
% nChunks
nChunks = [160, 35, 12, 450];
% prefStartTime
prefStartTime = [0, 6, 0, 18];
% deadline
deadline = [32, 7, 100000, 48];
% availBW
availBW = [39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 70, 70, 70, 70, 70, 35, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 26, 40, 40, 40, 40, 40, 40, 40, 26, 13, 0, 0, 0, 0, 0; 0, 35, 71, 71, 71, 71, 71, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
