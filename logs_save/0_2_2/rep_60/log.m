% t_n_i
% time:
generate_model = 7682;
duration_to_solve_model_us = 388;
create_model = 42;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0];
allocatedChunks(:,:,2) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 18, 0, 0; 0, 17, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
allocatedChunks(:,:,3) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 12, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
allocatedChunks(:,:,4) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 60; 0, 0, 40, 0; 0, 0, 40, 0; 0, 0, 40, 0; 0, 0, 40, 0; 30, 0, 0, 0; 25, 0, 0, 0; 25, 0, 0, 0; 25, 0, 0, 0; 25, 0, 0, 0; 25, 0, 0, 0; 25, 0, 0, 0];
% non_allocated
non_allocated = [30, 0, 0, 50];
% dl_vio
dl_vio = [0, 0, 0, 0];
% st_vio
st_vio = [0, 0, 0, 3040];
% vioThroughput
vioThroughput = [0, 0, 0, 0];
% non_allo_vio
non_allo_vio = [1680, 0, 0, 2100];
% nChunks
nChunks = [155, 35, 12, 450];
% prefStartTime
prefStartTime = [0, 6, 0, 18];
% deadline
deadline = [31, 7, 100000, 48];
% availBW
availBW = [30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30; 0, 0, 0, 17, 35, 53, 53, 53, 53, 53, 53, 35, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 45, 45, 45, 45, 45, 22, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 21, 43, 65, 65, 65, 65, 65, 65, 43, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0];
